/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 身份角色信息
  +  Created by 王大宸 on 2024-04-27 21:22:14
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
var userRolePath = HTTP_BIZ_URI + "/admin/user/role/info";
var userRoleDeptParentId = '';
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    form.render();
    userRoleDeptParentId = $('#parentId').val();

    initUserRoleDeptTree(table, form);

    initUserRoleLayTable(table, form);

});


function initUserRoleDeptTree(table) {
    $.zTree.initTree({
        id: 'userRoleTree',
        url: HTTP_BIZ_URI + '/admin/dept/info/tree',
        callback: function (event, treeId, treeNode) {
            userRoleDeptParentId = treeNode.id;
            reloadUserRoleTableData(table, {})
            if ('1' === userRoleDeptParentId) {
                $('#headBarTool').attr('style', 'display:none')
            }

        }
    })
}


function initUserRoleLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitUserRoleOptions())

    /* 表头事件监听 */
    toolUserRoleBar(table);

    /* 操作栏监听 */
    toolUserRole(table);

    /* 导出 */
    form.on('submit(expUserRoleInfo)', function (data) {
        let uri = queryUriObjParams(userRolePath + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryUserRoleInfo)', function (data) {
        reloadUserRoleTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            reloadUserRoleTableData(table)
            return false;
        }
    })

    /**
     * 有效标志监听
     */
    form.on('switch(validFlagUserRoleFilter)', function (obj) {
        validFlagUserRoleFilter(table, this.value, obj.elem.checked)
    });

}

/**
 * 刷新表格数据
 * @param table
 * @param params
 */
function reloadUserRoleTableData(table) {
    $.table.reloadData(table, tableInitUserRoleOptions());
}


/**
 * 表头操作
 * @param table
 */
function toolUserRoleBar(table) {
    table.on('toolbar(userRoleInfoLayFilter)', function (obj) {
        if ('saveUserRoleInfo' === obj.event) {
            $.flyer.openIframe({
                title: '新增',
                content: userRolePath + '/' + userRoleDeptParentId + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function toolUserRole(table) {
    table.on('tool(userRoleInfoLayFilter)', function (obj) {
        let data = obj.data;
        if ('delete' === obj.event) {
            $.table.delete({
                url: userRolePath + '/' + data.id,
                title: data.roleName,
                reloadTable: reloadUserRoleTableData
            })
        }
        if ('auz' === obj.event) {
            let uri = HTTP_BIZ_URI + '/admin/auth/role/menu/' + data.id + '/index';
            $.flyer.full('特权设置', uri)

        }
        if ('clazz' === obj.event) {
            $.flyer.openIframe({
                title: '岗位设置',
                content: userRolePath + '/clazz/' + data.id,
                area: ['350px', '500px']
            })
        }

        if ('grant' === obj.event) {
            let uri = HTTP_BIZ_URI + '/admin/auth/grant/menu/' + data.id + '/index';
            $.flyer.full('权限下发', uri)


            // $.flyer.openIframe({
            //     title: '编辑',
            //     content: path + '/edit/' + data.id
            // })
        }
        if ('update' === obj.event) {
            $.flyer.openIframe({
                title: '编辑',
                content: userRolePath + '/edit/' + data.id
            })
        }
        if ('view' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看',
                content: userRolePath + '/view/' + data.id
            })
        }
    })
}

function queryUserRoleWhere() {
    return {
        deptId: userRoleDeptParentId
    }
}

function tableInitUserRoleOptions() {
    return {
        id: 'userRoleInfoLayTable',
        elem: '#userRoleInfoLayTable',
        layFilter: 'userRoleInfoLayFilter',
        toolbar: '#userInfoToolbar',
        url: userRolePath + "/page",
        where: queryUserRoleWhere(),
        cols: [[
            {field: 'nickName', title: '姓名', width: 160, align: "center"},
            {field: 'roleName', title: '身份名称', align: "center"},
            {
                field: 'roleFlag', title: '是否主身份', width: 120, align: "center", templet: function (d) {
                    if ('Y' === d.roleFlag) {
                        return '是'
                    }
                    return '否'
                }
            },
            {field: 'validFlag', title: '有效标志', width: 120, align: "center", templet: "#validFlagTpl"},
            // {field: 'deptId', title: '身份部门ID', align: "center"},
            // {field: 'deptTitle', title: '身份部门名称', align: "center"},
            // {field: 'startTime', title: '身份有效期起', align: "center"},
            // {field: 'endTime', title: '身份有效期止', align: "center"},
            // {field: 'orderNum', title: '排序', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolUserRoleActionBar', width: 600, align: "center"}
        ]]
    }

}


/**
 * 更新有效标志状态
 * @param table
 * @param id
 * @param checked
 */
function validFlagUserRoleFilter(table, id, checked) {
    $.http.post({
        url: userRolePath + '/' + id + '/valid/' + checked,
        callback: function (res) {
            $.msg.msgSuccess('有效标志更改成功！');
        },
        errCallback: function (err) {
            reloadUserRoleTableData(table);
            $.msg.msgWarning(err.msg);
        }
    })
}
