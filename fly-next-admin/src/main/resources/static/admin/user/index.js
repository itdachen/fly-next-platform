/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 用户信息
  +  Created by 王大宸 on 2023-04-04 21:44:46
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path =  HTTP_BIZ_URI + "/admin/user/info";
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
              let username = $("#username").val();
              let name = $("#name").val();
              let departId = $("#departId").val();
              let tenantId = $("#tenantId").val();
              let clientId = $("#clientId").val();
    return {
                    username: username,
                    name: name,
                    departId: departId,
                    tenantId: tenantId,
                    clientId: clientId,
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
        if ('saveUserInfo' === obj.event) {
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
                    {field: 'username', title: '登录账户', align: "center"},
                    {field: 'password', title: '登录密码', align: "center"},
                    {field: 'name', title: '姓名', align: "center"},
                    {field: 'avatar', title: '头像', align: "center"},
                    {field: 'birthday', title: '出生日期', align: "center"},
                    {field: 'address', title: '地址', align: "center"},
                    {field: 'telephone', title: '电话号码', align: "center"},
                    {field: 'email', title: '电子邮箱', align: "center"},
                    {field: 'departId', title: '部门ID', align: "center"},
                    {field: 'sex', title: '性别: 数据字典-sys_sex', align: "center"},
                    {field: 'type', title: '类型', align: "center"},
                    {field: 'status', title: '状态: 数据字典: user_status 0-冻结;1-正常', align: "center"},
                    {field: 'clientId', title: '客户端ID', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', width: "20%", align: "center"}
        ]]
    }

}

