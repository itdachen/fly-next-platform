/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 按钮资源
  +  Created by 王大宸 on 2023-04-04 21:52:58
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path =  HTTP_BIZ_URI + "/admin/element/info";
layui.use(['table'], function () {
    let table = layui.table;

    /* 初始化表格 */
    $.table.init(table, options())

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);
});

/**
 * 数据表格查询条件(必须有,不然表格重载不了)
 */
function queryWhere() {
              let menuId = $("#menuId").val();
              let title = $("#title").val();
              let code = $("#code").val();
              let type = $("#type").val();
              let href = $("#href").val();
              let path = $("#path").val();
              let method = $("#method").val();
              let orderNum = $("#orderNum").val();
              let visible = $("#visible").val();
    return {
                    menuId: menuId,
                    title: title,
                    code: code,
                    type: type,
                    href: href,
                    path: path,
                    method: method,
                    orderNum: orderNum,
                    visible: visible,
    }
}

/**
 * 刷新表格数据
 * @param table
 */
function reloadTableData(table) {
    $.table.reloadData(table, options());
}


/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if ('search' === obj.event) {
            reloadTableData(table);
        }
        if ('saveElementInfo' === obj.event) {
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

function options() {
    return {
        url: path + "/page",
        where: queryWhere(),
        cols: [[
                    {field: 'menuId', title: '资源关联菜单', align: "center"},
                    {field: 'title', title: '资源名称: 新增,编辑,删除 ... 等', align: "center"},
                    {field: 'code', title: '资源编码: 权限编码', align: "center"},
                    {field: 'type', title: '资源类型: button,uri', align: "center"},
                    {field: 'href', title: '资源路径, 路径动态参数使用{*}: /admin/user/{*}', align: "center"},
                    {field: 'path', title: '视图路径, 路径动态参数使用{*}: /admin/user/{*}', align: "center"},
                    {field: 'method', title: '资源请求类型:GET,POST,PUT,DELETE', align: "center"},
                    {field: 'orderNum', title: '排序', align: "center"},
                    {field: 'visible', title: '状态:1-可用,0-禁用', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', width: "20%", align: "center"}
        ]]
    }

}

