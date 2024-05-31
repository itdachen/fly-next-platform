/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 身份角色信息
  +  Created by 王大宸 on 2024-04-27 21:22:14
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/user/role/info";
var deptParentId = '';
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    deptParentId = $('#parentId').val();

    initDeptTree(table, form);

    initLayTable(table, form);

});


function initDeptTree(table) {
    $.zTree.initTree({
        url: HTTP_BIZ_URI + '/admin/dept/info/tree',
        callback: function (event, treeId, treeNode) {
            deptParentId = treeNode.id;
            reloadTableData(table, {})
            if ('1' === deptParentId) {
                $('#headBarTool').attr('style', 'display:none')
            }

        }
    })
}


function initLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitOptions({deptId: deptParentId}))

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    /* 导出 */
    form.on('submit(expUserRoleInfo)', function (data) {
        let uri = queryUriObjParams(path + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryUserRoleInfo)', function (data) {
        reloadTableData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            event.preventDefault();
            let obj = $.form.getFormValue('queryUserRoleInfo')
            reloadTableData(table, obj)
            return false;
        }
    })

    /**
     * 有效标志监听
     */
    form.on('switch(validFlagFilter)', function (obj) {
        validFlagFilter(table, this.value, obj.elem.checked)
    });

}

/**
 * 刷新表格数据
 * @param table
 * @param params
 */
function reloadTableData(table, params) {
    params.deptId = deptParentId;
    $.table.reloadData(table, tableInitOptions(params));
}


/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if ('saveUserRoleInfo' === obj.event) {
            $.flyer.openIframe({
                title: '新增',
                content: path + '/' + deptParentId + '/add'
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
        if ('auz' === obj.event) {
            let uri = HTTP_BIZ_URI + '/admin/auth/role/menu/' + data.id + '/index';
            $.flyer.full('特权设置', uri)

        }
        if ('clazz' === obj.event) {
            $.flyer.openIframe({
                title: '岗位设置',
                content: path + '/clazz/' + data.id,
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
                content: path + '/edit/' + data.id
            })
        }
        if ('view' === obj.event) {
            $.flyer.openIframeSee({
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
            {fixed: 'right', title: '操作', toolbar: '#toolActionBar', width: 600, align: "center"}
        ]]
    }

}


/**
 * 更新有效标志状态
 * @param table
 * @param id
 * @param checked
 */
function validFlagFilter(table, id, checked) {
    $.http.post({
        url: path + '/' + id + '/valid/' + checked,
        callback: function (res) {
            $.msg.msgSuccess('有效标志更改成功！');
        },
        errCallback: function (err) {
            let obj = $.form.getFormValue('queryPlatformInfo')
            reloadTableData(table, obj);
            $.msg.msgWarning(err.msg);
        }
    })
}
