/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 部门岗位关联表
  +  Created by 王大宸 on 2024-05-10 21:17:50
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/clazz/dept";
var deptParentId = 'root';
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
        }
    })
}


function initLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitOptions({}))

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    /* 导出 */
    form.on('submit(expClazzDept)', function (data) {
        let uri = queryUriObjParams(path + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryClazzDept)', function (data) {
        reloadTableData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            event.preventDefault();
            let obj = $.form.getFormValue('queryClazzDept')
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
        if ('saveClazzDept' === obj.event) {
            $.flyer.full('设置部门岗位', path + '/' + deptParentId + '/add')
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
            {field: 'clazzTitle', title: '岗位名称', width: 320, align: "center"},
            {field: 'remarks', title: '备注', align: "center"},
            {field: 'validFlag', title: '有效标志', width: 200, align: "center", templet: "#validFlagTpl"}
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
            initDeptTree(table, null);
            let obj = $.form.getFormValue('queryClazzDept')
            reloadTableData(table, obj);
            $.msg.msgSuccess('有效标志更改成功！');
        },
        errCallback: function (err) {
            let obj = $.form.getFormValue('queryClazzDept')
            initDeptTree(table, null);
            reloadTableData(table, obj);
            $.msg.msgWarning(err.msg);
        }
    })
}
