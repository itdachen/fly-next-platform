/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 数据字典类型
  +  Created by 王大宸 on 2024-04-21 20:29:55
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
var dictTypePath = HTTP_BIZ_URI + "/admin/dict/type";
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    initDictTypeLayTable(table, form);

});


function initDictTypeLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitDictTypeOptions())

    /* 表头事件监听 */
    toolDictTypeBar(table);

    /* 操作栏监听 */
    toolDictType(table);

    /* 导出 */
    form.on('submit(expDictType)', function (data) {
        let uri = queryUriObjParams(dictTypePath + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryDictType)', function (data) {
        reloadDictTypeTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            reloadDictTypeTableData(table)
            return false;
        }
    })

}

/**
 * 刷新表格数据
 * @param table
 */
function reloadDictTypeTableData(table) {
    $.table.reloadData(table, tableInitDictTypeOptions());
}


/**
 * 表头操作
 * @param table
 */
function toolDictTypeBar(table) {
    table.on('toolbar(dictTypeLayFilter)', function (obj) {
        if ('saveDictType' === obj.event) {
            $.flyer.openIframe({
                title: '新增',
                content: dictTypePath + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function toolDictType(table) {
    table.on('tool(dictTypeLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteDictType' === obj.event) {
            $.table.delete({
                url: dictTypePath + '/' + data.id,
                title: data.dictLabel,
                reloadTable: reloadDictTypeTableData
            })
        }
        if ('updateDictType' === obj.event) {
            $.flyer.openIframe({
                title: '编辑',
                content: dictTypePath + '/edit/' + data.id
            })
        }
        if ('viewDictType' === obj.event) {
            let uri = HTTP_BIZ_URI + '/admin/dict/data/' + data.id + '/index';
            $.flyer.full(data.dictLabel + '【 ' + data.dictType + ' 】', uri);
        }
    })
}

function queryDictTypeWhere() {
    return {
        dictLabel: $('#dictLabel').val()
    }
}

function tableInitDictTypeOptions() {
    return {
        id: 'dictTypeLayTable',
        elem: '#dictTypeLayTable',
        layFilter: 'dictTypeLayFilter',
        toolbar: '#dictTypeToolbar',
        url: dictTypePath + "/page",
        where: queryDictTypeWhere(),
        cols: [[
            {field: 'dictLabel', title: '字典标签', width: 320, align: "center"},
            {field: 'dictType', title: '字典类型', width: 320, align: "center"},
            {
                field: 'validFlag', title: '有效标志', width: 120, align: "center", templet: function (d) {
                    if ('Y' === d.validFlag) {
                        return '有效'
                    }
                    return '无效'
                }
            },
            {field: 'remarks', title: '备注', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#dictTypeToolActionBar', width: 380, align: "center"}
        ]]
    }

}

