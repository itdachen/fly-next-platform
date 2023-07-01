/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 登录日志
  +  Created by 王大宸 on 2023-06-30 22:39:02
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/record/login";
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
    let nickname = $("#nickname").val();
    let username = $("#username").val();
    let status = $("#status").val();
    return {
        nickname: nickname,
        username: username,
        status: status,
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
        if ('saveLoginRecord' === obj.event) {
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
            // {field: 'sessionId', title: '会话id', align: "center"},
            // {field: 'clientId', title: '客户端', align: "center", width: 150},
            {field: 'nickname', title: '登录者姓名', align: "center", width: 120},
            {field: 'username', title: '登录账号', align: "center", width: 150},
            {field: 'os', title: '操作系统', align: "center", width: 100},
            {field: 'browser', title: '浏览器', align: "center", width: 150},
            {
                field: 'status', title: '登录状态', width: 100, align: "center", templet: function (d) {
                    if ('1' == d.status) {
                        return '成功';
                    } else {
                        return '失败';
                    }
                }
            },
            {field: 'ip', title: '登录IP地址', align: "center", width: 120},
            {field: 'accessAddress', title: '登录地点', align: "center"},
            {field: 'msg', title: '提示消息', align: "center"},
            // {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', width: "10%", align: "center"}
        ]]
    }

}

