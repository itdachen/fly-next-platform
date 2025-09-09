/*
 ++++++++++++++++++++++++++++++++++
 + 操作日志
 + @author 王大宸
 + @date 2025-09-09 17:52:15
 ++++++++++++++++++++++++++++++++++
 */
var OPLOG_INFO_PATH = HTTP_BIZ_URI + '/oplog/info';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initOplogInfoLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initOplogInfoLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, oplogInfoTableOptions({}));

    /* 表头事件监听 */
    oplogInfoToolBar(table);

    /* 操作栏监听 */
    oplogInfoActionBar(table);

    /* 导出 */
    form.on('submit(expOplogInfo)', function (data) {
        let expUri = queryUriObjParams(OPLOG_INFO_PATH + '/exp', data.field)
        //  window.open(expUri);
        $.http.get({
            url: expUri,
            callback: function (res) {
                $.msg.alertMsg(res.msg);
            }
        })
        return false;
    })

    /* 查询 */
    form.on('submit(queryOplogInfo)', function (data) {
        reloadOplogInfoTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            // event.preventDefault();
            // let obj = $.form.getFormValue('queryOplogInfo')
            reloadOplogInfoTableData(table)
            return false;
        }
    })

}

/**
 * 表头操作
 * @param table
 */
function oplogInfoToolBar(table) {
    table.on('toolbar(oplogInfoLayFilter)', function (obj) {
        if ('saveOplogInfo' === obj.event) {
            $.flyer.openIframe({
                title: '新增操作日志',
                content: OPLOG_INFO_PATH + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function oplogInfoActionBar(table) {
    table.on('tool(oplogInfoLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteOplogInfo' === obj.event) {
            $.table.delete({
                url: OPLOG_INFO_PATH + '/' + data.id,
                title: data.name,
                reloadTable: reloadOplogInfoTableData
            })
        }
        if ('viewOplogInfo' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看操作日志',
                content: OPLOG_INFO_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadOplogInfoTableData(table) {
    let queryOplogInfoParams = $.form.getFormValue('queryOplogInfoForm')
    $.table.reloadData(table, oplogInfoTableOptions(queryOplogInfoParams));
}

/**
 * 表格参数
 */
function oplogInfoTableOptions(queryOplogInfoParams) {
    return {
        id: 'oplogInfoLayTable',
        elem: '#oplogInfoLayTable',
        // toolbar: '#oplogInfoToolBar',  // 不展示表头设置成 false
        toolbar: false,
        layFilter: 'oplogInfoLayFilter',
        url: OPLOG_INFO_PATH + '/page',
        where: queryOplogInfoParams,
        cols: [[
            {field: 'menuTitle', title: '日志标题', align: 'center'},
            {field: 'opTitle', title: '操作类型', align: 'center'},
            {field: 'opTime', title: '操作时间', align: 'center'},
            {field: 'userId', title: '操作人工号', align: 'center'},
            {field: 'nickName', title: '操作人姓名', align: 'center'},
            {field: 'provName', title: '省名称', align: 'center'},
            {field: 'cityName', title: '市州名称', align: 'center'},
            {field: 'countyName', title: '区县名称', align: 'center'},
            {field: 'townName', title: '乡镇/街道办名称', align: 'center'},
            {field: 'deptTitle', title: '部门名称', align: 'center'},
            {field: 'hostIp', title: '操作IP地址', align: 'center'},
            {field: 'hostAddress', title: '操作地址', align: 'center'},
            {field: 'hostOs', title: '操作系统', align: 'center'},
            {field: 'hostBrowser', title: '操作浏览器', align: 'center'},
            {field: 'responseStatus', title: '操作状态', align: 'center'},
            {field: 'responseMsg', title: '返回消息', align: 'center'},
            {fixed: 'right', title: '操作', toolbar: '#oplogInfoActionBar', width: 320, align: 'center'}
        ]]
    }

}

