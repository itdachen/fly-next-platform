/*
 ++++++++++++++++++++++++++++++++++
 + 导出日志
 + @author 王大宸
 + @date 2025-07-23 23:06:08
 ++++++++++++++++++++++++++++++++++
 */
var OPLOG_POI_EXP_PATH = HTTP_BIZ_URI + '/oplog/poi/exp';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initOplogPoiExpLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initOplogPoiExpLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, oplogPoiExpTableOptions({}));

    /* 操作栏监听 */
    oplogPoiExpActionBar(table);

    /* 导出 */
    form.on('submit(expOplogPoiExp)', function (data) {
        let expUri = queryUriObjParams(OPLOG_POI_EXP_PATH + '/exp', data.field)
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
    form.on('submit(queryOplogPoiExp)', function (data) {
        reloadOplogPoiExpTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            // event.preventDefault();
            // let obj = $.form.getFormValue('queryOplogPoiExp')
            reloadOplogPoiExpTableData(table)
            return false;
        }
    })

}

/**
 * 表格操作
 * @param table
 */
function oplogPoiExpActionBar(table) {
    table.on('tool(oplogPoiExpLayFilter)', function (obj) {
        let data = obj.data;
        if ('viewOplogPoiExp' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看导出日志',
                content: OPLOG_POI_EXP_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadOplogPoiExpTableData(table) {
    let queryOplogPoiExpParams = $.form.getFormValue('queryOplogPoiExpForm')
    $.table.reloadData(table, oplogPoiExpTableOptions(queryOplogPoiExpParams));
}

/**
 * 表格参数
 */
function oplogPoiExpTableOptions(queryOplogPoiExpParams) {
    return {
        id: 'oplogPoiExpLayTable',
        elem: '#oplogPoiExpLayTable',
      //  toolbar: '#oplogPoiExpToolBar',  // 不展示表头设置成 false
        toolbar: false,
        layFilter: 'oplogPoiExpLayFilter',
        url: OPLOG_POI_EXP_PATH + '/page',
        where: queryOplogPoiExpParams,
        cols: [[
           // {field: 'appTitle', title: '应用名称', align: 'center'},
            {field: 'funcTitle', title: '功能名称', align: 'center'},
            {field: 'nickName', title: '导出人', width: 150, align: 'center'},
            // {field: 'provTitle', title: '省名称', align: 'center'},
            // {field: 'cityTitle', title: '市/州名称', align: 'center'},
            // {field: 'countyTitle', title: '区/县名称', align: 'center'},
            {field: 'deptTitle', title: '部门名称', align: 'center'},
            {field: 'hostIp', title: 'IP地址', width: 180, align: 'center'},
            {field: 'dataTotal', title: '数据总量', width: 150, align: 'center'},
            {field: 'fileTotal', title: '文件数量', width: 150, align: 'center'},
            {field: 'createTime', title: '导出时间', width: 180, align: 'center'},
            {fixed: 'right', title: '操作', toolbar: '#oplogPoiExpActionBar', width: 180, align: 'center'}
        ]]
    }

}

