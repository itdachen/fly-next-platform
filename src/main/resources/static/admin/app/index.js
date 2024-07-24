/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 应用信息
  +  Created by 王大宸 on 2024-04-19 21:22:54
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
var appPath = HTTP_BIZ_URI + "/admin/app/info";
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    initAppLayTable(table, form);

});


function initAppLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, appAppInfoTableOptions())

    /* 表头事件监听 */
    appToolBar(table);

    /* 操作栏监听 */
    appTool(table);

    /* 导出 */
    form.on('submit(expAppInfo)', function (data) {
        let uri = appPath + '/exp';
        let expUri = queryUriObjParams(uri, data.field);
        window.open(expUri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryAppInfo)', function (data) {
        reloadAppTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            event.preventDefault();
            let obj = $.form.getFormValue('queryAppInfoForm')
            reloadAppTableData(table, obj)
            return false;
        }
    })

    /**
     * 有效标志监听
     */
    form.on('switch(validAppFlagFilter)', function (obj) {
        validAppFlagFilter(table, this.value, obj.elem.checked)
    });

}

/**
 * 刷新表格数据
 * @param table
 * @param queryParams
 */
function reloadAppTableData(table) {
    $.table.reloadData(table, appAppInfoTableOptions());
}


/**
 * 表头操作
 * @param table
 */
function appToolBar(table) {
    table.on('toolbar(appLayFilter)', function (obj) {
        if ('searchAppInfo' === obj.event) {
            reloadAppTableData(table);
        }
        if ('saveAppInfo' === obj.event) {
            $.flyer.openIframe({
                title: '新增',
                content: appPath + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function appTool(table) {
    table.on('tool(appLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteApp' === obj.event) {
            $.table.delete({
                url: appPath + '/' + data.id,
                title: data.appTitle,
                reloadTable: reloadAppTableData
            })
        }
        if ('updateApp' === obj.event) {
            $.flyer.openIframe({
                title: '编辑',
                content: appPath + '/edit/' + data.id
            })
        }
        if ('viewApp' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看',
                content: appPath + '/view/' + data.id
            })
        }
    })
}


function queryAppInfoParams() {
    return {
        appTitle: $('#appTitle').val(),
        validFlag: $('#validFlag').val()
    }
}

function appAppInfoTableOptions() {
    return {
        id: 'appLayTable',
        elem: '#appLayTable',
        layFilter: 'appLayFilter',
        toolbar: '#appToolbar',
        url: appPath + "/page",
        where: queryAppInfoParams(),
        cols: [[
            {field: 'platTitle', title: '平台名称', width: 180, align: "center"},
            {field: 'appTitle', title: '应用名称', width: 180, align: "center"},
            // {field: 'id', title: 'appId',  align: "center"},
            // {field: 'appSecret', title: 'app秘钥', align: "center"},
            //  {field: 'typeTitle', title: '应用类型标题',width: 100, align: "center"},
            {field: 'askUri', title: '访问地址', align: "center"},
            //  {field: 'iconIco', title: '图标', align: "center"},
            //  {field: 'funcTitle', title: '职能', align: "center"},
            {field: 'appCode', title: '应用标识', width: 180, align: "center"},
            {field: 'validFlag', title: '有效标志', width: 100, align: "center", templet: "#validAppFlagTpl"},
            {fixed: 'right', title: '操作', toolbar: '#appToolActionBar', width: 320, align: "center"}
        ]]
    }

}

/**
 * 更新有效标志状态
 * @param table
 * @param id
 * @param checked
 */
function validAppFlagFilter(table, id, checked) {
    $.http.post({
        url: appPath + '/' + id + '/valid/' + checked,
        callback: function (res) {
            $.msg.msgSuccess('有效标志更改成功！');
        },
        errCallback: function (err) {
            let obj = $.form.getFormValue('queryPlatformInfo')
            reloadAppTableData(table, obj);
            $.msg.msgWarning(err.msg);
        }
    })
}
