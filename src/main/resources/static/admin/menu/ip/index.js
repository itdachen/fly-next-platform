/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 菜单白名单
  +  Created by 王大宸 on 2024-04-20 22:25:57
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path =  HTTP_BIZ_URI + "/admin/white/ip/list";
layui.use(function () {
    let table = layui.table;
    let form = layui.form;

    initLayTable(table,form);

});


function initLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitOptions({}))

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    /* 导出 */
    form.on('submit(expWhiteIpList)', function (data) {
        let uri = queryUriObjParams(path + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryWhiteIpList)', function (data) {
        reloadTableData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            event.preventDefault();
            let obj = $.form.getFormValue('queryWhiteIpList')
            reloadTableData(table, obj)
            return false;
        }
    })

}

/**
 * 刷新表格数据
 * @param table
 * @param params
 */
function reloadTableData(table, params) {
    $.table.reloadData(table, tableInitOptions(params));
}


/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if ('saveWhiteIpList' === obj.event) {
            $.model.openIframe({
                title: '新增',
                content: path + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function tool(table) {
    table.on('tool(layFilter)', function (obj) {
        let data = obj.data;
        if ('delete' === obj.event) {
            $.table.delete({
                url: path + '/' + data.id,
                title: data.name
            })
        }
        if ('update' === obj.event) {
            $.model.openIframe({
                title: '编辑',
                content: path + '/edit/' + data.id
            })
        }
        if ('view' === obj.event) {
            $.model.openIframeSee({
                title: '查看',
                content: path + '/view/' + data.id
            })
        }
    })
}

function tableInitOptions(params = {}) {
    return {
        url: path + "/page",
        where: params,
        cols: [[
                    {field: 'appId', title: '应用ID/appID', align: "center"},
                    {field: 'ipType', title: '类型: menu-菜单;element-按钮', align: "center"},
                    {field: 'menuId', title: '菜单ID', align: "center"},
                    {field: 'menuTitle', title: '菜单名称', align: "center"},
                    {field: 'elementId', title: '按钮ID', align: "center"},
                    {field: 'elementTitle', title: '按钮名称', align: "center"},
                    {field: 'typeId', title: '白名单类型', align: "center"},
                    {field: 'typeTitle', title: '类型名: 固定IP/范围IP', align: "center"},
                    {field: 'hostIp', title: '固定IP', align: "center"},
                    {field: 'hostIpValue', title: '固定IP的值', align: "center"},
                    {field: 'startIp', title: '起始IP', align: "center"},
                    {field: 'startIpValue', title: '起始IP的值', align: "center"},
                    {field: 'endIp', title: '结束IP', align: "center"},
                    {field: 'endIpValue', title: '结束IP的值', align: "center"},
                    {field: 'validFlag', title: '是否展示/有效标志: Y-有效;N-无效', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolActionBar', width: 320, align: "center"}
        ]]
    }

}

