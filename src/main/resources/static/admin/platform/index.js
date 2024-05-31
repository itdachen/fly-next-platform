/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 平台信息
  +  Created by 王大宸 on 2024-04-20 16:04:52
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/platform/info";
layui.use(function () {
    let table = layui.table;
    let form = layui.form;

    initLayTable(table, form);

});


function initLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitOptions({}))

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    /* 导出 */
    form.on('submit(expPlatformInfo)', function (data) {
        let uri = queryUriObjParams(path + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryPlatformInfo)', function (data) {
        reloadTableData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            event.preventDefault();
            let obj = $.form.getFormValue('queryPlatformInfo')
            reloadTableData(table, obj)
            return false;
        }
    })

    /**
     * 有效标志监听
     */
    form.on('checkbox(validFlagFilter)', function (obj) {
        validFlagFilter(table, this.value, obj.elem.checked);
    });


}

/**
 * 刷新表格数据
 * @param table
 * @param params
 */
function reloadTableData(table, params) {
    $.table.reloadData(table, tableInitOptions(params));
}


/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if ('savePlatformInfo' === obj.event) {
            $.flyer.openIframe({
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
            {field: 'title', title: '平台名称', width: 500, align: "center"},
            //  {field: 'iconIco', title: '图标', align: "center"},
            // {field: 'funcCode', title: '职能代码', align: "center"},
            // {field: 'funcTitle', title: '职能名称', align: "center"},
            // {field: 'validDel', title: '是否可删除: Y-是;N-否', align: "center"},
            {field: 'remarks', title: '备注', align: "center"},
            {field: 'validFlag', title: '有效标志', width: 100, align: "center", templet: "#validFlagTpl"},
            {fixed: 'right', title: '操作', toolbar: '#toolActionBar', width: 320, align: "center"}
        ]]
    }
}

/**
 * 更新有效标志状态
 * @param table
 * @param id
 * @param checked
 */
function validFlagFilter(table,id, checked) {
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

