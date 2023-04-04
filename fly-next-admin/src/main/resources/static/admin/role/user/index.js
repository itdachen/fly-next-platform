/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 用户角色
  +  Created by 王大宸 on 2023-04-04 21:44:46
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path =  HTTP_BIZ_URI + "/admin/role/user";
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
              let userId = $("#userId").val();
              let roleId = $("#roleId").val();
    return {
                    userId: userId,
                    roleId: roleId,
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
        if ('saveRoleUser' === obj.event) {
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
                    {field: 'userId', title: '用户id', align: "center"},
                    {field: 'roleId', title: '角色id', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', width: "20%", align: "center"}
        ]]
    }

}

