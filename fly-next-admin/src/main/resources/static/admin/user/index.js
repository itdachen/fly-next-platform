/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 用户信息
  +  Created by 王大宸 on 2023-04-04 21:44:46
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
var departId = 'ROOT';
const path = HTTP_BIZ_URI + "/admin/user/info";
layui.use(['table'], function () {
    let table = layui.table;

    initTree();

    /* 初始化表格 */
    $.table.init(table, options())

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    /* 隐藏新增按钮 */
    if ('ROOT' === departId) {
        $('#headBarTool').attr('style', 'display:none')
    }


});

/**
 * 数据表格查询条件(必须有,不然表格重载不了)
 */
function queryWhere() {
    let name = $("#name").val();
    return {
        name: name,
        departId: departId
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
            location.href = path + '/' + departId + '/add';
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
            location.href = path + '/edit/' + data.id;
        }
        if ('view' === obj.event) {
            location.href = path + '/view/' + data.id;
        }
    })
}

function options() {
    return {
        url: path + "/page",
        where: queryWhere(),
        cols: [[
            {field: 'username', title: '登录账户', align: "center"},
            {field: 'name', title: '姓名', align: "center"},
            {
                field: 'avatar',
                title: '头像',
                align: "center",
                event: "openAvatar",
                templet: function (d) {
                    if ($.string.isNotEmpty(d.avatar)) {
                        return '<img style="width:50px;height:50px;cursor:pointer;border-radius: 50%;" src="' + d.avatar + '" />';
                    } else {
                        return '';
                    }
                }
            },
            {field: 'telephone', title: '电话号码', align: "center"},
            {field: 'email', title: '电子邮箱', width: 130, align: "center"},
            {
                field: 'sex', title: '性别', align: "center", width: 80, templet: function (d) {
                    if ('1' === d.sex) {
                        return '男';
                    } else if ('2' === d.sex) {
                        return '女';
                    } else {
                        return '未知';
                    }
                }
            },
            {
                field: 'status', title: '状态', align: "center", width: 110, templet: function (d) {
                    if ('1' === d.status) {
                        return '正常';
                    } else {
                        return '冻结';
                    }
                }
            },
            {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', width: "25%", align: "center"}
        ]]
    }

}

function initTree() {
    $.zTree.initTree({
        url: "/admin/dept/info/zTree",
        callback: function (event, treeId, treeNode) {
            $('#headBarTool').attr('style', 'display:block')
            departId = treeNode.id;
            reloadTableData()
        }
    })
}