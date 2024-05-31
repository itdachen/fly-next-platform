/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 认证资源信息(按钮信息)
  +  Created by 王大宸 on 2024-04-20 22:25:57
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const pathElementUri = HTTP_BIZ_URI + "/admin/element/info";
var flyMenuParentId = '';
layui.use(function () {
    let table = layui.table;
    let form = layui.form;

    initElementLayTable(table, form);

});


function initElementLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitElementOptions({}))

    /* 表头事件监听 */
    toolElementBar(table);

    /* 操作栏监听 */
    toolElement(table);

    /* 导出 */
    form.on('submit(expElementInfo)', function (data) {
        let uri = queryUriObjParams(pathElementUri + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryElementInfo)', function (data) {
        reloadTableElementData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            event.preventDefault();
            let obj = $.form.getFormValue('queryElementInfo')
            reloadTableElementData(table, obj)
            return false;
        }
    })

    /**
     * 有效标志监听
     */
    form.on('checkbox(validFlagElementFilter)', function (obj) {
        validFlagElementFilter(table, this.value, obj.elem.checked);
    });

}

/**
 * 刷新表格数据
 * @param table
 * @param params
 */
function reloadTableElementData(table, params = {}) {
    params.appId = $('#appId').val();
    params.menuId = flyMenuParentId;
    $.table.reloadData(table, tableInitElementOptions(params));
}


/**
 * 表头操作
 * @param table
 */
function toolElementBar(table) {
    table.on('toolbar(layElementFilter)', function (obj) {
        let appId = $('#appId').val();
        if ('saveElementInfo' === obj.event) {
            $.flyer.openIframe({
                title: '新增',
                content: pathElementUri + '/' + appId + '/menu/' + flyMenuParentId + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function toolElement(table) {
    table.on('tool(layElementFilter)', function (obj) {
        let data = obj.data;
        if ('delete' === obj.event) {
            $.table.delete({
                url: pathElementUri + '/' + data.id,
                title: data.name
            })
        }
        if ('update' === obj.event) {
            $.flyer.openIframe({
                title: '编辑',
                content: pathElementUri + '/edit/' + data.id
            })
        }
        if ('view' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看',
                content: pathElementUri + '/view/' + data.id
            })
        }
    })
}

function tableInitElementOptions(params = {}) {
    return {
        id: 'layElementTable',
        elem: '#layElementTable',
        toolbar: '#toolElementBar',
        layFilter: 'layElementFilter',
        url: pathElementUri + "/page",
        where: params,
        cols: [[
            // {field: 'appId', title: '应用ID/appID', align: "center"},
            // {field: 'menuId', title: '菜单ID', align: "center"},
            {field: 'title', title: '资源名称', align: "center"},
            {field: 'authCode', title: '认证编码', align: "center"},
            {
                field: 'type', title: '类型', align: "center", templet: function (d) {
                    if ('uri' === d.type) {
                        return '链接';
                    }
                    if ('button' === d.type) {
                        return '按钮';
                    }
                    return '按钮';
                }
            },
            // {field: 'pageUri', title: '页面访问地址', align: "center"},
            // {field: 'apiUri', title: '接口请求地址', align: "center"},
            //{field: 'httpMethod', title: 'API请求类型: POST/GET/PUT/DELETE', align: "center"},
            {field: 'orderNum', title: '排序', align: "center"},
            // {field: 'thirdParty', title: '第三方平台标识', align: "center"},
            // {field: 'thirdTitle', title: '第三方平台名称', align: "center"},
            // {field: 'thirdUri', title: '第三方基础访问地址, 例如: http://www.baidu.com', align: "center"},
            // {field: 'askUri', title: '最终访问地址, 根据第三方平台信息拼接', align: "center"},
            {field: 'validFlag', title: '有效标志', align: "center", width: 150, templet: "#validFlagElementTpl"},
            // {field: 'hasAuth', title: '是否需要授权: Y-需要;N-不需要', align: "center"},
            // {field: 'hasIp', title: '是否需要IP授权: Y-需要;N-不需要', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolElementActionBar', width: 320, align: "center"}
        ]]
    }

}


/**
 * 更新有效标志状态
 * @param table
 * @param id
 * @param checked
 */
function validFlagElementFilter(table, id, checked) {
    $.http.post({
        url: pathElementUri + '/' + id + '/valid/' + checked,
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
