/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 部门岗位关联表
  +  Created by 王大宸 on 2024-05-10 21:17:50
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/clazz/dept";
layui.use(function () {
    let table = layui.table;
    let form = layui.form;

    initLayTable(table, form);

});


function initLayTable(table, form) {
    let deptId = $('#deptId').val();
    /* 初始化表格 */
    $.table.init(table, tableInitOptions({deptId: deptId}))

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

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

}

/**
 * 刷新表格数据
 * @param table
 * @param params
 */
function reloadTableData(table, params) {
    params.deptId = $('#deptId').val();
    $.table.reloadData(table, tableInitOptions(params));
}


/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if ('saveClazzDept' === obj.event) {
            let checkStatus = table.checkStatus('layTable');
            let data = checkStatus.data;
            if (0 === data.length) {
                $.msg.msgWarning("请选择需要添加的岗位!")
                return;
            }
            let clazzIds = [];
            for (let i = 0; i < data.length; i++) {
                clazzIds.push(data[i].id);
            }
            saveDeptClazz(clazzIds.join());
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
        if ('view' === obj.event) {
            saveDeptClazz(data.id);
        }
    })
}

function tableInitOptions(params = {}) {
    return {
        url: path + "/clazz/page",
        where: params,
        cols: [[
            {type: 'checkbox', fixed: 'left'},//多选框
            {field: 'name', title: '岗位名称', width: 320, align: "center"},
            {field: 'remarks', title: '备注', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolActionBar', width: 130, align: "center"}
        ]]
    }

}

/**
 * 新增岗位信息
 * @param clazzId
 */
function saveDeptClazz(clazzId) {
    let data = {
        deptId: $('#deptId').val(),
        clazzId: clazzId
    }
    $.http.post({
        url: path,
        data: data,
        callback: function (res) {
            if (200 === res.status) {
                layer.alert('添加成功', {title: "系统提示", icon: 1}, function () {
                    $.flyer.close();
                });
            } else {
                layer.alert(res.msg, {title: "系统提示", icon: 2});
            }
        }
    })
}
