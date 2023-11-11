/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 日志表
  +  Created by 王大宸 on 2023-04-06 22:00:57
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/make/use/log";
layui.use(['table'], function () {
    let table = layui.table;

    /* 初始化表格 */
    $.table.init(table, options())

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    initClientId();

});

/**
 * 数据表格查询条件(必须有,不然表格重载不了)
 */
function queryWhere() {
    let clientId = $("#clientId").val();
    let menuTitle = $("#menuTitle").val();
    return {
        clientId: clientId,
        menuTitle: menuTitle,
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
        if ('view' === obj.event) {
            let title = data.menuTitle + ' [ ' + data.makeUseType + ' ] ';
            parent.layer.open({
                type: 2,
                content: path + '/view/' + data.id,
                area: ['800px', '720px'],
                fix: false,
                maxmin: false,
                shade: 0.3,
                title: title,
                btn: ['关闭'],
                shadeClose: false,
                cancel: function (index) {
                    return true;
                }
            });

            // $.model.openIframeSee({
            //     title: '查看',
            //     content: path + '/view/' + data.id
            // })
        }
    })
}

function options() {
    return {
        url: path + "/page",
        where: queryWhere(),
        cols: [[
            {field: 'clientId', title: '客户端', align: "center"},
            {field: 'menuTitle', title: '日志标题', align: "center"},
            {field: 'makeUseType', title: '操作类型', align: "center"},
            {field: 'logType', title: '日志类型', align: "center"},
            {field: 'makeUseIp', title: '操作IP', align: "center"},
            {field: 'makeUseAddress', title: '操作地址', align: "center"},
            {field: 'makeUseStatus', title: '操作状态', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', width: "20%", align: "center"}
        ]]
    }

}

function initClientId() {
    for (let i = 0; i < clients.length; i++) {
        $('#clientId').append('<option value="' + clients[i].value + '">' + clients[i].label + '</option>')
    }
    $('#clientId').append('<option value="">未知客户端</option>')
}

function getRemoteType(value) {
    for (let i = 0; i < logType.length; i++) {
        if (value === logType[i].value) {
            return logType[i].label;
        }
    }
    return '未知操作'
}


const clients = [
    {
        value: 'PC',
        label: '电脑浏览器'
    },
    {
        value: 'WE_CHAT',
        label: '微信小程序'
    },
    {
        value: 'MOBILE_APP',
        label: '手机APP'
    },
    {
        value: 'AUTH_CODE',
        label: '授权码模式'
    },
    {
        value: 'OTHER_CLIENT',
        label: '其他客户端'
    },
]

const logType = [
    {
        value: '0',
        label: '其他操作'
    },
    {
        value: '1',
        label: '新增'
    },
    {
        value: '2',
        label: '编辑'
    },
    {
        value: '3',
        label: '删除'
    },
    {
        value: '4',
        label: '获取数据'
    },
    {
        value: '5',
        label: '页面跳转'
    },
    {
        value: '6',
        label: '授权'
    },
    {
        value: '7',
        label: '导入'
    },
    {
        value: '8',
        label: '导出'
    },
    {
        value: '9',
        label: '强退'
    },
    {
        value: '10',
        label: '生成代码'
    },
    {
        value: '11',
        label: '清空'
    },
    {
        value: '12',
        label: '显示权限'
    }
]
