/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 用户信息
  +  Created by 王大宸 on 2024-04-27 20:42:58
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/user/info";
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
    form.on('submit(expUserInfo)', function (data) {
        let uri = queryUriObjParams(path + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryUserInfo)', function (data) {
        reloadTableData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            event.preventDefault();
            let obj = $.form.getFormValue('queryUserInfo')
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
    $.table.reloadData(table, tableInitOptions(params));
}


/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if ('saveUserInfo' === obj.event) {
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
            // {field: 'tenantTitle', title: '租户名称', align: "center"},
            {field: 'nickName', title: '昵称', width: 200, align: "center"},
            {field: 'idCard', title: '身份证号码', width: 200, align: "center"},
            {
                field: 'sex', title: '性别', align: "center", width: 120, templet: function (d) {
                    if ('1' === d.sex) {
                        return '男'
                    }
                    if ('2' === d.sex) {
                        return '女'
                    }
                    return '未知'
                }
            },
            {field: 'telephone', title: '电话号码', align: "center"},
            {field: 'eMailBox', title: '电子邮箱', align: "center"},
            {field: 'validFlag', title: '有效标志', align: "center", width: 120, templet: "#validFlagTpl"},
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
function validFlagFilter(table, id, checked) {
    $.http.post({
        url: path + '/' + id + '/valid/' + checked,
        callback: function (res) {
            $.msg.msgSuccess('有效标志更改成功！');
        },
        errCallback: function (err) {
            let obj = $.form.getFormValue('queryTenantInfo')
            reloadTableData(table, obj);
            $.msg.msgWarning(err.msg);
        }
    })
}
