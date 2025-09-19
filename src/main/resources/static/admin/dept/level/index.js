/*
 ++++++++++++++++++++++++++++++++++
 + 部门等级
 + @author 王大宸
 + @date 2025-09-18 22:02:49
 ++++++++++++++++++++++++++++++++++
 */
var DEPT_LEVEL_PATH = HTTP_BIZ_URI + '/admin/dept/level';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initDeptLevelLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initDeptLevelLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, deptLevelTableOptions({}));

    /* 表头事件监听 */
    deptLevelToolBar(table);

    /* 操作栏监听 */
    deptLevelActionBar(table);

    /* 导出 */
    form.on('submit(expDeptLevel)', function (data) {
        let expUri = queryUriObjParams(DEPT_LEVEL_PATH + '/exp', data.field)
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
    form.on('submit(queryDeptLevel)', function (data) {
        reloadDeptLevelTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            // event.preventDefault();
            // let obj = $.form.getFormValue('queryDeptLevel')
            reloadDeptLevelTableData(table)
            return false;
        }
    })

}

/**
 * 表头操作
 * @param table
 */
function deptLevelToolBar(table) {
    table.on('toolbar(deptLevelLayFilter)', function (obj) {
        if ('saveDeptLevel' === obj.event) {
            $.flyer.openIframe({
                title: '新增',
                content: DEPT_LEVEL_PATH + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function deptLevelActionBar(table) {
    table.on('tool(deptLevelLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteDeptLevel' === obj.event) {
            $.table.delete({
                url: DEPT_LEVEL_PATH + '/' + data.id,
                title: data.name,
                reloadTable: reloadDeptLevelTableData
            })
        }
        if ('updateDeptLevel' === obj.event) {
            $.flyer.openIframe({
                title: '编辑',
                content: DEPT_LEVEL_PATH + '/edit/' + data.id
            })
        }
        if ('viewDeptLevel' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看',
                content: DEPT_LEVEL_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadDeptLevelTableData(table) {
    let queryDeptLevelParams = $.form.getFormValue('queryDeptLevelForm')
    $.table.reloadData(table, deptLevelTableOptions(queryDeptLevelParams));
}

/**
 * 表格参数
 */
function deptLevelTableOptions(queryDeptLevelParams) {
    return {
        id: 'deptLevelLayTable',
        elem: '#deptLevelLayTable',
        // toolbar: '#deptLevelToolBar',  // 不展示表头设置成 false
        toolbar: false,  // 不展示表头设置成 false
        layFilter: 'deptLevelLayFilter',
        url: DEPT_LEVEL_PATH + '/page',
        where: queryDeptLevelParams,
        cols: [[
            {field: 'levelCode', title: '层级代码', width: 180, align: 'center'},
            {field: 'levelTitle', title: '层级名称', width: 320, align: 'center'},
            {
                field: 'validFlag', title: '有效标志', width: 180, align: 'center', templet: function (d) {
                    if ('Y' === d.validFlag) {
                        return '有效';
                    }
                    return '无效';
                }
            },
            {field: 'remarks', title: '备注', align: 'center'},
           // {fixed: 'right', title: '操作', toolbar: '#deptLevelActionBar', width: 320, align: 'center'}
        ]]
    }

}

