/*
 ++++++++++++++++++++++++++++++++++
 + 岗位职能管理
 + @author 王大宸
 + @date 2025-09-18 22:27:28
 ++++++++++++++++++++++++++++++++++
 */
var CLAZZ_FUNC_PATH = HTTP_BIZ_URI + '/admin/clazz/func';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initClazzFuncLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initClazzFuncLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, clazzFuncTableOptions({}));

    /* 表头事件监听 */
    clazzFuncToolBar(table);

    /* 操作栏监听 */
    clazzFuncActionBar(table);

    /* 导出 */
    form.on('submit(expClazzFunc)', function (data) {
        let expUri = queryUriObjParams(CLAZZ_FUNC_PATH + '/exp', data.field)
        //  window.open(expUri);
        $.http.get({
            url: expUri,
            callback: function (res) {
                $.msg.alertMsg(res.msg);
            }
        })
        return false;
    })

    /* 查询 */
    form.on('submit(queryClazzFunc)', function (data) {
        reloadClazzFuncTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            // event.preventDefault();
            // let obj = $.form.getFormValue('queryClazzFunc')
            reloadClazzFuncTableData(table)
            return false;
        }
    })

}

/**
 * 表头操作
 * @param table
 */
function clazzFuncToolBar(table) {
    table.on('toolbar(clazzFuncLayFilter)', function (obj) {
        if ('saveClazzFunc' === obj.event) {
            $.flyer.openIframe({
                title: '新增岗位职能管理',
                content: CLAZZ_FUNC_PATH + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function clazzFuncActionBar(table) {
    table.on('tool(clazzFuncLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteClazzFunc' === obj.event) {
            $.table.delete({
                url: CLAZZ_FUNC_PATH + '/' + data.id,
                title: data.name,
                reloadTable: reloadClazzFuncTableData
            })
        }
        if ('updateClazzFunc' === obj.event) {
            $.flyer.openIframe({
                title: '编辑岗位职能管理',
                content: CLAZZ_FUNC_PATH + '/edit/' + data.id
            })
        }
        if ('viewClazzFunc' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看岗位职能管理',
                content: CLAZZ_FUNC_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadClazzFuncTableData(table) {
    let queryClazzFuncParams = $.form.getFormValue('queryClazzFuncForm')
    $.table.reloadData(table, clazzFuncTableOptions(queryClazzFuncParams));
}

/**
 * 表格参数
 */
function clazzFuncTableOptions(queryClazzFuncParams) {
    return {
        id: 'clazzFuncLayTable',
        elem: '#clazzFuncLayTable',
        toolbar: '#clazzFuncToolBar',  // 不展示表头设置成 false
        layFilter: 'clazzFuncLayFilter',
        url: CLAZZ_FUNC_PATH + '/page',
        where: queryClazzFuncParams,
        cols: [[
            {field: 'funcCode', title: '岗位职能编码', width: 180, align: 'center'},
            {field: 'funcTitle', title: '岗位职能标题', align: 'center'},
            {
                field: 'validFlag', title: '有效标志', width: 180, align: 'center', templet: function (d) {
                    if ('Y' === d.validFlag) {
                        return '有效';
                    }
                    return '无效';
                }
            },
            {field: 'remarks', title: '备注', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#clazzFuncActionBar', width: 320, align: 'center'}
        ]]
    }

}

