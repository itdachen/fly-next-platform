/*
 ++++++++++++++++++++++++++++++++++
 + 部门职能管理
 + @author 王大宸
 + @date 2025-09-18 23:03:17
 ++++++++++++++++++++++++++++++++++
 */
var DEPT_FUNC_PATH = HTTP_BIZ_URI + '/admin/dept/func';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initDeptFuncLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initDeptFuncLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, deptFuncTableOptions({}));

    /* 表头事件监听 */
    deptFuncToolBar(table);

    /* 操作栏监听 */
    deptFuncActionBar(table);

    /* 导出 */
    form.on('submit(expDeptFunc)', function (data) {
        let expUri = queryUriObjParams(DEPT_FUNC_PATH + '/exp', data.field)
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
    form.on('submit(queryDeptFunc)', function (data) {
        reloadDeptFuncTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            // event.preventDefault();
            // let obj = $.form.getFormValue('queryDeptFunc')
            reloadDeptFuncTableData(table)
            return false;
        }
    })

}

/**
 * 表头操作
 * @param table
 */
function deptFuncToolBar(table) {
    table.on('toolbar(deptFuncLayFilter)', function (obj) {
        if ('saveDeptFunc' === obj.event) {
            $.flyer.openIframe({
                title: '新增部门职能管理',
                content: DEPT_FUNC_PATH + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function deptFuncActionBar(table) {
    table.on('tool(deptFuncLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteDeptFunc' === obj.event) {
            $.table.delete({
                url: DEPT_FUNC_PATH + '/' + data.id,
                title: data.name,
                reloadTable: reloadDeptFuncTableData
            })
        }
        if ('updateDeptFunc' === obj.event) {
            $.flyer.openIframe({
                title: '编辑部门职能管理',
                content: DEPT_FUNC_PATH + '/edit/' + data.id
            })
        }
        if ('viewDeptFunc' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看部门职能管理',
                content: DEPT_FUNC_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadDeptFuncTableData(table) {
    let queryDeptFuncParams = $.form.getFormValue('queryDeptFuncForm')
    $.table.reloadData(table, deptFuncTableOptions(queryDeptFuncParams));
}

/**
 * 表格参数
 */
function deptFuncTableOptions(queryDeptFuncParams) {
    return {
        id: 'deptFuncLayTable',
        elem: '#deptFuncLayTable',
        toolbar: '#deptFuncToolBar',  // 不展示表头设置成 false
        layFilter: 'deptFuncLayFilter',
        url: DEPT_FUNC_PATH + '/page',
        where: queryDeptFuncParams,
        cols: [[
            {field: 'funcCode', title: '部门职能编码', width: 320, align: 'center'},
            {field: 'title', title: '职能标题', align: 'center'},
            {field: 'titleAs', title: '职能简称', align: 'center'},
            {
                field: 'validFlag', title: '有效标志', width: 180, align: 'center', templet: function (d) {
                    if ('Y' === d.validFlag) {
                        return '有效';
                    }
                    return '无效';
                }
            },
            {field: 'remarks', title: '备注', align: 'center'},
            {fixed: 'right', title: '操作', toolbar: '#deptFuncActionBar', width: 320, align: 'center'}
        ]]
    }

}

