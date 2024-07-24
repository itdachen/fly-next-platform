/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 数据字典信息表
  +  Created by 王大宸 on 2024-04-21 20:29:55
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/dict/data";
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    initLayTable(table, form);

});


function initLayTable(table, form) {
    /* 初始化表格 */
    let typeId = $('#typeId').val();
    $.table.init(table, tableInitOptions({typeId: typeId}))

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    /* 导出 */
    form.on('submit(expDictData)', function (data) {
        let uri = queryUriObjParams(path + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryDictData)', function (data) {
        reloadTableData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            event.preventDefault();
            let obj = $.form.getFormValue('queryDictData')
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
    if (undefined === params || null === params) {
        params = $.form.getFormValue('queryDictData')
    }
    $.table.reloadData(table, tableInitOptions(params));
}


/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if ('saveDictData' === obj.event) {
            let typeId = $('#typeId').val();
            $.flyer.openIframe({
                title: '新增',
                content: path + '/' + typeId + '/add'
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
            // {field: 'typeId', title: '数据字典类型ID', align: "center"},
            // {field: 'typeLabel', title: '数据字典类型名称', align: "center"},
            // {field: 'dictType', title: '字典类型', align: "center"},
            {field: 'dictLabel', title: '字典标签', align: "center"},
            {field: 'dictValue', title: '字典键值', align: "center"},
            {
                field: 'isDefault', title: '是否默认', align: "center", templet: function (d) {
                    if ('1' === d.isDefault) {
                        return '是'
                    }
                    return '否'
                }
            },
            {field: 'dictSort', title: '字典排序', align: "center"},
            {
                field: 'validFlag', title: '有效标志', align: "center", templet: function (d) {
                    if ('Y' === d.validFlag) {
                        return '有效'
                    }
                    return '无效'
                }
            },
            {fixed: 'right', title: '操作', toolbar: '#toolActionBar', width: 320, align: "center"}
        ]]
    }

}

