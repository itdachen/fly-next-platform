/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 平台信息
  +  Created by 王大宸 on 2024-04-20 16:04:52
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
var platformInfoPath = HTTP_BIZ_URI + "/admin/platform/info";
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    initPlatformInfoLayTable(table, form);

});


function initPlatformInfoLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitPlatformInfoOptions())

    /* 表头事件监听 */
    toolPlatformInfoBar(table);

    /* 操作栏监听 */
    toolPlatformInfo(table);

    /* 导出 */
    form.on('submit(expPlatformInfo)', function (data) {
        let uri = queryUriObjParams(platformInfoPath + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryPlatformInfo)', function (data) {
        reloadPlatformInfoTableData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            reloadPlatformInfoTableData(table)
            return false;
        }
    })

    /**
     * 有效标志监听
     */
    form.on('checkbox(validFlagPlatformInfoFilter)', function (obj) {
        validFlagPlatformInfoFilter(table, this.value, obj.elem.checked);
    });


}

/**
 * 刷新表格数据
 * @param table
 * @param params
 */
function reloadPlatformInfoTableData(table) {
    $.table.reloadData(table, tableInitPlatformInfoOptions());
}


/**
 * 表头操作
 * @param table
 */
function toolPlatformInfoBar(table) {
    table.on('toolbar(platformInfoLayFilter)', function (obj) {
        if ('savePlatformInfo' === obj.event) {
            $.flyer.openIframe({
                title: '新增',
                content: platformInfoPath + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function toolPlatformInfo(table) {
    table.on('tool(platformInfoLayFilter)', function (obj) {
        let data = obj.data;
        if ('delete' === obj.event) {
            $.table.delete({
                url: platformInfoPath + '/' + data.id,
                title: data.name
            })
        }
        if ('update' === obj.event) {
            $.flyer.openIframe({
                title: '编辑',
                content: platformInfoPath + '/edit/' + data.id
            })
        }
        if ('view' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看',
                content: platformInfoPath + '/view/' + data.id
            })
        }
    })
}

function queryPlatformInfoWhere() {
    let title = $('#title').val();
    let validFlag = $('#validFlag').val();
    return {
        title: title,
        validFlag: validFlag
    }
}


function tableInitPlatformInfoOptions() {
    return {
        id: 'platformInfoLayTable',
        elem: '#platformInfoLayTable',
        layFilter: 'platformInfoLayFilter',
        toolbar: '#platformInfoToolbar',
        url: platformInfoPath + "/page",
        where: queryPlatformInfoWhere(),
        cols: [[
            {field: 'title', title: '平台名称', width: 500, align: "center"},
            //  {field: 'iconIco', title: '图标', align: "center"},
            // {field: 'funcCode', title: '职能代码', align: "center"},
            // {field: 'funcTitle', title: '职能名称', align: "center"},
            // {field: 'validDel', title: '是否可删除: Y-是;N-否', align: "center"},
            {field: 'remarks', title: '备注', align: "center"},
            {field: 'validFlag', title: '有效标志', width: 100, align: "center", templet: "#validFlagPlatformInfoTpl"},
            {fixed: 'right', title: '操作', toolbar: '#platformInfoActionBar', width: 320, align: "center"}
        ]]
    }
}

/**
 * 更新有效标志状态
 * @param table
 * @param id
 * @param checked
 */
function validFlagPlatformInfoFilter(table, id, checked) {
    $.http.post({
        url: platformInfoPath + '/' + id + '/valid/' + checked,
        callback: function (res) {
            $.msg.msgSuccess('有效标志更改成功！');
        },
        errCallback: function (err) {
            reloadPlatformInfoTableData(table);
            $.msg.msgWarning(err.msg);
        }
    })
}

