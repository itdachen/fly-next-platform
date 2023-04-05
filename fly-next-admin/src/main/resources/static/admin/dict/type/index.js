/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 字典类型表
  +  Created by 王大宸 on 2023-04-04 21:44:47
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/dict/type";
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;

    /* 初始化表格 */
    $.table.init(table, options())

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    form.on('checkbox(statusTpl)', function (obj) {
        onStatusTpl(this.value, obj.elem.checked);
    });

});

/**
 * 数据表格查询条件(必须有,不然表格重载不了)
 */
function queryWhere() {
    let dictName = $("#dictName").val();
    let dictType = $("#dictType").val();
    let status = $("#status").val();
    return {
        dictName: dictName,
        dictType: dictType,
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
        if ('saveDictType' === obj.event) {
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
            location.href = '/admin/dict/data/' + data.dictType + '/index'
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
            {field: 'dictName', title: '字典名称', align: "center"},
            {field: 'dictType', title: '字典类型', align: "center"},
            {field: 'status', title: '状态', align: "center", templet: "#statusTpl"},
            {field: 'remarks', title: '备注', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', width: "20%", align: "center"}
        ]]
    }

}


function onStatusTpl(dataId, status) {
    $.http.put({
        url: path + '/' + dataId + '/status/' + status,
        callback: function (res) {
            if (status) {
                $.msg.msgSuccess('解除禁用成功');
            } else {
                $.msg.msgSuccess('禁用成功');
            }
        },
        errCallback: function (err) {
            $.msg.msgWarning(err.msg);
        }
    })
}
