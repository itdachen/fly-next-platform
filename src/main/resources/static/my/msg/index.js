/*
 ++++++++++++++++++++++++++++++++++
 + 消息池
 + @author 王大宸
 + @date 2025-07-11 22:52:18
 ++++++++++++++++++++++++++++++++++
 */
var MY_MSG_POOL_PATH = HTTP_BIZ_URI + '/my/msg';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initmsgPoolMyLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initmsgPoolMyLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, msgPoolTableOptions(table, {}));

    /* 表头事件监听 */
   // msgPoolToolBar(table);

    /* 操作栏监听 */
    msgPoolActionBar(table);

    /* 导出 */
    form.on('submit(expMsgPool)', function (data) {
        let uri = queryUriObjParams(MY_MSG_POOL_PATH + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryMsgPool)', function (data) {
        reloadMsgPoolTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            // event.preventDefault();
            // let obj = $.form.getFormValue('queryMsgPool')
            reloadMsgPoolTableData(table)
            return false;
        }
    })

}


/**
 * 表格操作
 * @param table
 */
function msgPoolActionBar(table) {
    // 行单击事件( 双击事件为: rowDouble )
    table.on('row(msgPoolMyLayFilter)', function (obj) {
        let data = obj.data; // 获取当前行数据
        viewMsgPoolInfo(table, data);
    });

    table.on('tool(msgPoolMyLayFilter)', function (obj) {
        let data = obj.data;
        if ('viewMsgPool' === obj.event) {
            viewMsgPoolInfo(table, data);
        }
    })

}


/**
 * 刷新表格数据
 * @param table
 */
function reloadMsgPoolTableData(table) {
    let queryMsgPoolParams = $.form.getFormValue('queryMsgPoolForm')
    $.table.reloadData(table, msgPoolTableOptions(table, queryMsgPoolParams));
}

/**
 * 表格参数
 */
function msgPoolTableOptions(table, queryMsgPoolParams) {
    return {
        id: 'msgPoolMyLayTable',
        elem: '#msgPoolMyLayTable',
        //  toolbar: '#msgPoolToolBar',  // 不展示表头设置成 false
        toolbar: false,
        layFilter: 'msgPoolMyLayFilter',
        url: MY_MSG_POOL_PATH + '/page',
        where: queryMsgPoolParams,
        cols: [[
            {
                field: 'title', title: '消息标题', align: 'left', templet(d) {
                    if ('N' === d.readFlag) {
                        return '<span style="font-weight:bold;cursor: pointer;">' + d.title + '</span>'
                    }
                    return '<span style="cursor: pointer;">' + d.title + '</span>'
                }
            },
            {
                field: 'readFlag', title: '阅读标志', width: 120, align: 'center', templet(d) {
                    if ('Y' === d.readFlag) {
                        return '已阅读'
                    }
                    return '未阅读';
                }
            },
            {field: 'createTime', title: '创建时间', width: 180, align: 'center'},
            {fixed: 'right', title: '操作', toolbar: '#msgPoolActionBar', width: 180, align: 'center'}
        ]]
    }

}


function viewMsgPoolInfo(table, data) {
    $.http.post({
        url: MY_MSG_POOL_PATH + '/read/' + data.id,
        callback: function (res) {

            let readData = res.data;

            /* 刷新表格 */
            reloadMsgPoolTableData(table)

            let width = ($(window).width() - 20);
            let height = ($(window).height() - 20);
            layer.open({
                type: 2,
                title: '【' + readData.msgTypeTitle + '】' + readData.title,
                content: $.http.verifyURL(MY_MSG_POOL_PATH + '/view/' + readData.id),
                area: [width + 'px', height + 'px'],
                fix: false,
                maxmin: false,
                shade: 0.3,
                shadeClose: false
            });
        }
    })


}
