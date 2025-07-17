/*
 ++++++++++++++++++++++++++++++++++
 + 消息池
 + @author 王大宸
 + @date 2025-07-11 22:52:18
 ++++++++++++++++++++++++++++++++++
 */
var MSG_POOL_PATH = HTTP_BIZ_URI + '/msg/pool';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initMsgPoolLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initMsgPoolLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, msgPoolTableOptions({}));

    /* 表头事件监听 */
    msgPoolToolBar(table);

    /* 操作栏监听 */
    msgPoolActionBar(table);

    /* 导出 */
    form.on('submit(expMsgPool)', function (data) {
        let uri = queryUriObjParams(MSG_POOL_PATH + '/exp', data.field)
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
 * 表头操作
 * @param table
 */
function msgPoolToolBar(table) {
    table.on('toolbar(msgPoolLayFilter)', function (obj) {
        if ('saveMsgPool' === obj.event) {
            $.flyer.openIframe({
                title: '新增消息池',
                content: MSG_POOL_PATH + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function msgPoolActionBar(table) {
    table.on('tool(msgPoolLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteMsgPool' === obj.event) {
            $.table.delete({
                url: MSG_POOL_PATH + '/' + data.id,
                title: data.name,
                reloadTable: reloadMsgPoolTableData
            })
        }
        if ('updateMsgPool' === obj.event) {
            $.flyer.openIframe({
                title: '编辑消息池',
                content: MSG_POOL_PATH + '/edit/' + data.id
            })
        }
        if ('viewMsgPool' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看消息池',
                content: MSG_POOL_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadMsgPoolTableData(table) {
    let queryMsgPoolParams = $.form.getFormValue('queryMsgPoolForm')
    $.table.reloadData(table, msgPoolTableOptions(queryMsgPoolParams));
}

/**
 * 表格参数
 */
function msgPoolTableOptions(queryMsgPoolParams) {
    return {
        id: 'msgPoolLayTable',
        elem: '#msgPoolLayTable',
        // toolbar: '#msgPoolToolBar',  // 不展示表头设置成 false
        toolbar: false,
        layFilter: 'msgPoolLayFilter',
        url: MSG_POOL_PATH + '/page',
        where: queryMsgPoolParams,
        cols: [[
            {field: 'msgTitle', title: '消息标题', align: 'left'},
            {field: 'readFlag', title: '阅读标志', width: 120, align: 'center'},
            {field: 'createTime', title: '创建时间', width: 180, align: 'center'},
            {fixed: 'right', title: '操作', toolbar: '#msgPoolActionBar', width: 180, align: 'center'}
        ]]
    }

}

