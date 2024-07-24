/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 租户/公司信息
  +  Created by 王大宸 on 2024-04-24 22:42:35
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
var tenantInfoPath = HTTP_BIZ_URI + "/admin/tenant/info";
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    initTenantInfoLayTable(table, form);

});


function initTenantInfoLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitTenantInfoOptions())

    /* 表头事件监听 */
    toolTenantInfoBar(table);

    /* 操作栏监听 */
    toolTenantInfo(table);

    /* 导出 */
    form.on('submit(expTenantInfo)', function (data) {
        let uri = queryUriObjParams(tenantInfoPath + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryTenantInfo)', function (data) {
        reloadTenantInfoTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            reloadTenantInfoTableData(table)
            return false;
        }
    })

    /**
     * 有效标志监听
     */
    form.on('switch(validFlagTenantInfoFilter)', function (obj) {
        validFlagTenantInfoFilter(table, this.value, obj.elem.checked)
    });

}

/**
 * 刷新表格数据
 * @param table
 * @param params
 */
function reloadTenantInfoTableData(table, params = {}) {
    $.table.reloadData(table, tableInitTenantInfoOptions(params));
}


/**
 * 表头操作
 * @param table
 */
function toolTenantInfoBar(table) {
    table.on('toolbar(tenantInfoLayFilter)', function (obj) {
        if ('saveTenantInfo' === obj.event) {
            $.flyer.openIframe({
                title: '新增',
                content: tenantInfoPath + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function toolTenantInfo(table) {
    table.on('tool(tenantInfoLayFilter)', function (obj) {
        let data = obj.data;
        if ('delete' === obj.event) {
            $.table.delete({
                url: tenantInfoPath + '/' + data.id,
                title: data.title,
                reloadTable: reloadTenantInfoTableData
            })
        }
        if ('update' === obj.event) {
            $.flyer.openIframe({
                title: '编辑',
                content: tenantInfoPath + '/edit/' + data.id
            })
        }
        if ('view' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看',
                content: tenantInfoPath + '/view/' + data.id
            })
        }
    })
}

function tableInitTenantInfoOptions(params = {}) {
    return {
        id: 'tenantInfoLayTable',
        elem: '#tenantInfoLayTable',
        layFilter: 'tenantInfoLayFilter',
        toolbar: '#tenantInfoToolbar',
        url: tenantInfoPath + "/page",
        where: params,
        cols: [[
            {field: 'title', title: '租户名称', align: "center"},
            {field: 'titleAs', title: '简称', align: "center"},
            // {field: 'eMailBox', title: '电子邮箱', align: "center"},
            {field: 'ownerNickName', title: '管理员', width: 180, align: "center"},
            {field: 'validFlag', title: '有效标志', width: 120, align: "center", templet: "#validFlagTenantInfoTpl"},
            {fixed: 'right', title: '操作', toolbar: '#toolTenantInfoActionBar', width: 600, align: "center"}
        ]]
    }

}


/**
 * 更新有效标志状态
 * @param table
 * @param id
 * @param checked
 */
function validFlagTenantInfoFilter(table, id, checked) {
    $.http.post({
        url: tenantInfoPath + '/' + id + '/valid/' + checked,
        callback: function (res) {
            $.msg.msgSuccess('有效标志更改成功！');
        },
        errCallback: function (err) {
            reloadTenantInfoTableData(table);
            $.msg.msgWarning(err.msg);
        }
    })
}
