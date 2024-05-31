/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 应用信息
  +  Created by 王大宸 on 2024-04-19 21:22:54
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/app/info";
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
    form.on('submit(expAppInfo)', function (data) {
        let uri = path + '/exp';
        let expUri = queryUriObjParams(uri, data.field);
        window.open(expUri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryAppInfo)', function (data) {
        reloadTableData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            event.preventDefault();
            let obj = $.form.getFormValue('queryAppInfoForm')
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
 * @param queryParams
 */
function reloadTableData(table, queryParams) {
    $.table.reloadData(table, tableInitOptions(queryParams));
}


/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if ('searchAppInfo' === obj.event) {
            reloadTableData(table);
        }
        if ('saveAppInfo' === obj.event) {
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
                title: data.appTitle
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

function tableInitOptions(queryParams = {}) {
    return {
        url: path + "/page",
        where: queryParams,
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
function validFlagFilter(table, id, checked) {
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
