/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 部门岗位关联表
  +  Created by 王大宸 on 2024-05-10 21:17:50
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
var deptClazzPath = HTTP_BIZ_URI + "/admin/clazz/dept";
var clazzDeptParentId = 'root';
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    clazzDeptParentId = $('#parentId').val();
    initClazzDeptTree(table, form);

    initClazzDeptLayTable(table, form);

});


function initClazzDeptTree(table) {
    $.zTree.initTree({
        id: 'clazzDeptTree',
        url: HTTP_BIZ_URI + '/admin/dept/info/tree',
        callback: function (event, treeId, treeNode) {
            clazzDeptParentId = treeNode.id;
            console.log(clazzDeptParentId)
            reloadClazzDeptTableData(table)
        }
    })
}


function initClazzDeptLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitClazzDeptOptions())

    /* 表头事件监听 */
    toolClazzDeptBar(table);

    /* 操作栏监听 */
    toolClazzDept(table);

    /* 导出 */
    form.on('submit(expClazzDept)', function (data) {
        let uri = queryUriObjParams(deptClazzPath + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryClazzDept)', function (data) {
        reloadClazzDeptTableData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            reloadClazzDeptTableData(table)
            return false;
        }
    })

    /**
     * 有效标志监听
     */
    form.on('switch(validFlagClazzDeptFilter)', function (obj) {
        validFlagClazzDeptFilter(table, this.value, obj.elem.checked)
    });

}

/**
 * 刷新表格数据
 * @param table
 */
function reloadClazzDeptTableData(table) {
    $.table.reloadData(table, tableInitClazzDeptOptions());
}


/**
 * 表头操作
 * @param table
 */
function toolClazzDeptBar(table) {
    table.on('toolbar(deptClazzLayFilter)', function (obj) {
        if ('saveClazzDept' === obj.event) {
            $.flyer.full('设置部门岗位', deptClazzPath + '/' + clazzDeptParentId + '/add')
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function toolClazzDept(table) {
    table.on('tool(deptClazzLayFilter)', function (obj) {
        let data = obj.data;
        if ('delete' === obj.event) {
            $.table.delete({
                url: deptClazzPath + '/' + data.id,
                title: data.name,
                reloadTable: reloadClazzDeptTableData,
            })
        }
        if ('update' === obj.event) {
            $.flyer.openIframe({
                title: '编辑',
                content: deptClazzPath + '/edit/' + data.id
            })
        }
        if ('view' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看',
                content: deptClazzPath + '/view/' + data.id
            })
        }
    })
}

function queryDeptClazzWhere() {
    return {
        deptId: clazzDeptParentId,
        clazzTitle: $('#clazzTitle').val(),
        validFlag: $('#validFlag').val()
    }
}

function tableInitClazzDeptOptions() {
    return {
        id: 'deptClazzLayTable',
        elem: '#deptClazzLayTable',
        layFilter: 'deptClazzLayFilter',
        toolbar: '#deptClazzToolbar',
        url: deptClazzPath + "/page",
        where: queryDeptClazzWhere(),
        cols: [[
            {field: 'clazzTitle', title: '岗位名称', width: 320, align: "center"},
            {field: 'remarks', title: '备注', align: "center"},
            {field: 'validFlag', title: '有效标志', width: 200, align: "center", templet: "#validFlagClazzDeptTpl"}
        ]]
    }
}


/**
 * 更新有效标志状态
 * @param table
 * @param id
 * @param checked
 */
function validFlagClazzDeptFilter(table, id, checked) {
    $.http.post({
        url: deptClazzPath + '/' + id + '/valid/' + checked,
        callback: function (res) {
            initDeptTree(table, null);
            reloadClazzDeptTableData(table);
            $.msg.msgSuccess('有效标志更改成功！');
        },
        errCallback: function (err) {
            initDeptTree(table, null);
            reloadClazzDeptTableData(table);
            $.msg.msgWarning(err.msg);
        }
    })
}
