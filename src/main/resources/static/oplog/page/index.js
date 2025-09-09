/*
 ++++++++++++++++++++++++++++++++++
 + 页面访问日志
 + @author 王大宸
 + @date 2025-09-09 21:56:31
 ++++++++++++++++++++++++++++++++++
 */
var OPLOG_PAGE_VIEW_PATH = HTTP_BIZ_URI + '/oplog/page/view';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initOplogPageViewLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initOplogPageViewLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, oplogPageViewTableOptions({}));

    /* 表头事件监听 */
    oplogPageViewToolBar(table);

    /* 操作栏监听 */
    oplogPageViewActionBar(table);

    /* 导出 */
    form.on('submit(expOplogPageView)', function (data) {
        let expUri = queryUriObjParams(OPLOG_PAGE_VIEW_PATH + '/exp', data.field)
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
    form.on('submit(queryOplogPageView)', function (data) {
        reloadOplogPageViewTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            // event.preventDefault();
            // let obj = $.form.getFormValue('queryOplogPageView')
            reloadOplogPageViewTableData(table)
            return false;
        }
    })

}

/**
 * 表头操作
 * @param table
 */
function oplogPageViewToolBar(table) {
    table.on('toolbar(oplogPageViewLayFilter)', function (obj) {
        if ('saveOplogPageView' === obj.event) {
            $.flyer.openIframe({
                title: '新增页面访问日志',
                content: OPLOG_PAGE_VIEW_PATH + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function oplogPageViewActionBar(table) {
    table.on('tool(oplogPageViewLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteOplogPageView' === obj.event) {
            $.table.delete({
                url: OPLOG_PAGE_VIEW_PATH + '/' + data.id,
                title: data.name,
                reloadTable: reloadOplogPageViewTableData
            })
        }
        if ('updateOplogPageView' === obj.event) {
            $.flyer.openIframe({
                title: '编辑页面访问日志',
                content: OPLOG_PAGE_VIEW_PATH + '/edit/' + data.id
            })
        }
        if ('viewOplogPageView' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看页面访问日志',
                content: OPLOG_PAGE_VIEW_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadOplogPageViewTableData(table) {
    let queryOplogPageViewParams = $.form.getFormValue('queryOplogPageViewForm')
    $.table.reloadData(table, oplogPageViewTableOptions(queryOplogPageViewParams));
}

/**
 * 表格参数
 */
function oplogPageViewTableOptions(queryOplogPageViewParams) {
    return {
        id: 'oplogPageViewLayTable',
        elem: '#oplogPageViewLayTable',
        toolbar: '#oplogPageViewToolBar',  // 不展示表头设置成 false
        layFilter: 'oplogPageViewLayFilter',
        url: OPLOG_PAGE_VIEW_PATH + '/page',
        where: queryOplogPageViewParams,
        cols: [[
            // {field: 'provName', title: '省名称', align: 'center'},
            // {field: 'cityName', title: '市州名称', align: 'center'},
            // {field: 'countyName', title: '区县名称', align: 'center'},
            // {field: 'townName', title: '乡镇/街道办名称', align: 'center'},
            {field: 'menuTitle', title: '菜单名称', width: 200, align: 'center'},
            {field: 'opTitle', title: '页面', width: 120, align: 'center'},
            {field: 'deptTitle', title: '部门', align: 'center'},
            {field: 'userId', title: '工号', width: 120, align: 'center'},
            {field: 'nickName', title: '姓名', width: 120, align: 'center'},
            {field: 'opTime', title: '时间', width: 160, align: 'center'},
            {field: 'hostIp', title: 'IP地址', width: 120, align: 'center'},
            {field: 'hostOs', title: '系统', width: 120, align: 'center'},
            {field: 'hostBrowser', title: '浏览器', width: 160, align: 'center'},
            // {field: 'executeTime', title: '服务端处理耗时', align: 'center'},
            {fixed: 'right', title: '操作', toolbar: '#oplogPageViewActionBar', width: 240, align: 'center'}
        ]]
    }

}

