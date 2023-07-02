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
    })
}

function options() {
    return {
        url: path + "/page",
        where: queryWhere(),
        cols: [[
            {field: 'nickname', title: '登录者姓名', align: "center"},
            {field: 'username', title: '登录账号', align: "center"},
            {field: 'signMethod', title: '登录方式', align: "center"},
            {field: 'os', title: '操作系统', align: "center"},
            {field: 'browser', title: '浏览器', align: "center"},
            {
                field: 'status', title: '登录状态', align: "center", templet: function (d) {
                    if ('1' == d.status) {
                        return '成功';
                    } else {
                        return '失败';
                    }
                }
            },
            {field: 'ip', title: '登录IP地址', align: "center"},
            {field: 'accessAddress', title: '登录地点', align: "center"},
            {field: 'msg', title: '提示消息', width: 400, align: "center"},
            {field: 'createTime', title: '登录时间', width: 180, align: "center"}
        ]]
    }

}

