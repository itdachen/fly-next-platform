/*
 ++++++++++++++++++++++++++++++++++
 + 导入日志
 + @author 王大宸
 + @date 2025-07-28 15:55:31
 ++++++++++++++++++++++++++++++++++
 */
var OPLOG_POI_IMP_PATH = HTTP_BIZ_URI + '/oplog/poi/imp';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initOplogPoiImpLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initOplogPoiImpLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, oplogPoiImpTableOptions({}));

    /* 表头事件监听 */
    oplogPoiImpToolBar(table);

    /* 操作栏监听 */
    oplogPoiImpActionBar(table);

    /* 导出 */
    form.on('submit(expOplogPoiImp)', function (data) {
        let expUri = queryUriObjParams(OPLOG_POI_IMP_PATH + '/exp', data.field)
        //  window.open(uri);
        $.http.get({
            url: expUri,
            callback: function (res) {
                layer.alert(res.msg);
            }
        })
        return false;
    })

    /* 查询 */
    form.on('submit(queryOplogPoiImp)', function (data) {
        reloadOplogPoiImpTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            // event.preventDefault();
            // let obj = $.form.getFormValue('queryOplogPoiImp')
            reloadOplogPoiImpTableData(table)
            return false;
        }
    })

}

/**
 * 表头操作
 * @param table
 */
function oplogPoiImpToolBar(table) {
    table.on('toolbar(oplogPoiImpLayFilter)', function (obj) {
        if ('saveOplogPoiImp' === obj.event) {
            $.flyer.openIframe({
                title: '新增导入日志',
                content: OPLOG_POI_IMP_PATH + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function oplogPoiImpActionBar(table) {
    table.on('tool(oplogPoiImpLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteOplogPoiImp' === obj.event) {
            $.table.delete({
                url: OPLOG_POI_IMP_PATH + '/' + data.id,
                title: data.name,
                reloadTable: reloadOplogPoiImpTableData
            })
        }
        if ('updateOplogPoiImp' === obj.event) {
            $.flyer.openIframe({
                title: '编辑导入日志',
                content: OPLOG_POI_IMP_PATH + '/edit/' + data.id
            })
        }
        if ('viewOplogPoiImp' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看导入日志',
                content: OPLOG_POI_IMP_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadOplogPoiImpTableData(table) {
    let queryOplogPoiImpParams = $.form.getFormValue('queryOplogPoiImpForm')
    $.table.reloadData(table, oplogPoiImpTableOptions(queryOplogPoiImpParams));
}

/**
 * 表格参数
 */
function oplogPoiImpTableOptions(queryOplogPoiImpParams) {
    return {
        id: 'oplogPoiImpLayTable',
        elem: '#oplogPoiImpLayTable',
        // toolbar: '#oplogPoiImpToolBar',  // 不展示表头设置成 false
        toolbar: false,  // 不展示表头设置成 false
        layFilter: 'oplogPoiImpLayFilter',
        url: OPLOG_POI_IMP_PATH + '/page',
        where: queryOplogPoiImpParams,
        cols: [[
            {field: 'funcTitle', title: '功能名称', align: 'center'},
            {field: 'nickName', title: '导入人', width: 150, align: 'center'},
            {field: 'deptTitle', title: '部门名称', align: 'center'},
            {field: 'hostIp', title: 'IP地址', width: 150, align: 'center'},
            {field: 'dataTotal', title: '数据总量', width: 150, align: 'center'},
            {field: 'createTime', title: '导入时间', width: 180, align: 'center'},
            {fixed: 'right', title: '操作', toolbar: '#oplogPoiImpActionBar', width: 180, align: 'center'}
        ]]
    }

}

