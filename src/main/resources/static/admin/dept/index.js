/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 部门信息
  +  Created by 王大宸 on 2024-04-24 21:47:25
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
var deptPath = HTTP_BIZ_URI + "/admin/dept/info";
var deptParentId = 'root';
var deptRootId = 'root';
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    let parentIdValue = $('#parentId').val();
    deptRootId = parentIdValue;
    deptParentId = parentIdValue;

    initDeptTree(table, form);

    initDeptLayTable(table, form);

});


function initDeptTree(table) {
    $.zTree.initTree({
        url: deptPath + '/tree',
        callback: function (event, treeId, treeNode) {
            deptParentId = treeNode.id;
            reloadDeptTableData(table);
        }
    })
}


function initDeptLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitDeptOptions())

    /* 表头事件监听 */
    toolDeptBar(table);

    /* 操作栏监听 */
    toolDept(table);

    /* 导出 */
    form.on('submit(expDeptInfo)', function (data) {
        let uri = queryUriObjParams(deptPath + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryDeptInfo)', function (data) {
        reloadDeptTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            reloadDeptTableData(table)
            return false;
        }
    })

    /**
     * 有效标志监听
     */
    form.on('switch(validFlagDeptInfoFilter)', function (obj) {
        validFlagDeptInfoFilter(table, this.value, obj.elem.checked)
    });

}


function queryDeptWhere() {
    let title = $("#title").val();
    let validFlag = $("#validFlag").val();
    return {
        appCode: title,
        validFlag: validFlag,
        parentId: deptParentId
    }
}

/**
 * 刷新表格数据
 * @param table
 * @param params
 */
function reloadDeptTableData(table) {
    $.table.reloadData(table, tableInitDeptOptions());
}


/**
 * 表头操作
 * @param table
 */
function toolDeptBar(table) {
    table.on('toolbar(deptInfoLayFilter)', function (obj) {
        if ('saveDeptInfo' === obj.event) {
            $.flyer.openIframe({
                title: '新增',
                content: deptPath + '/' + deptParentId + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function toolDept(table) {
    table.on('tool(deptInfoLayFilter)', function (obj) {
        let data = obj.data;
        if ('delete' === obj.event) {
            $.table.delete({
                url: deptPath + '/' + data.id,
                title: data.name,
                callback: function (res) {
                    initDeptTree();
                    reloadDeptTableData(table);
                    layer.msg(res.msg, {icon: 1, time: 1500});
                }
            })
        }
        if ('update' === obj.event) {
            $.flyer.openIframe({
                title: '编辑',
                content: deptPath + '/edit/' + data.id
            })
        }
        if ('view' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看',
                content: deptPath + '/view/' + data.id
            })
        }
    })
}

function tableInitDeptOptions() {
    return {
        id: 'deptInfoLayTable',
        elem: '#deptInfoLayTable',
        layFilter: 'deptInfoLayFilter',
        toolbar: '#deptInfoToolbar',
        url: deptPath + "/page",
        where: queryDeptWhere(),
        cols: [[
            {field: 'title', title: '部门名称', align: "center"},
            // {field: 'deptLevel', title: '部门级次', width: 180, align: "center"},
            {field: 'validFlag', title: '有效标志', width: 180, align: "center", templet: "#validFlagDeptInfoTpl"},
            {fixed: 'right', title: '操作', toolbar: '#toolDeptInfoActionBar', width: 320, align: "center"}
        ]]
    }

}

/**
 * 更新有效标志状态
 * @param table
 * @param id
 * @param checked
 */
function validFlagDeptInfoFilter(table, id, checked) {
    $.http.post({
        url: deptPath + '/' + id + '/valid/' + checked,
        callback: function (res) {
            initDeptTree(table, null);
            reloadDeptTableData(table);
            $.msg.msgSuccess('有效标志更改成功！');
        },
        errCallback: function (err) {
            initDeptTree(table, null);
            reloadDeptTableData(table);
            $.msg.msgWarning(err.msg);
        }
    })
}