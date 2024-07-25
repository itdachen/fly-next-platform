/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 岗位信息
  +  Created by 王大宸 on 2024-04-25 22:40:02
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
var clazzPath = HTTP_BIZ_URI + "/admin/clazz/info";
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    initClazzLayTable(table, form);

});


function initClazzLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, tableInitClazzOptions({}))

    /* 表头事件监听 */
    toolClazzInfoBar(table);

    /* 操作栏监听 */
    toolClazzInfo(table);

    /* 导出 */
    form.on('submit(expClazzInfo)', function (data) {
        let uri = queryUriObjParams(clazzPath + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryClazzInfo)', function (data) {
        reloadClazzTableData(table);
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            reloadClazzTableData(table)
            return false;
        }
    })

    /**
     * 有效标志监听
     */
    form.on('switch(validClazzFlagFilter)', function (obj) {
        validFlagClazzInfoFilter(table, this.value, obj.elem.checked)
    });

}

/**
 * 刷新表格数据
 * @param table
 */
function reloadClazzTableData(table) {
    let params = $.form.getFormValue('queryClazzInfo');
    $.table.reloadData(table, tableInitClazzOptions(params));
}


/**
 * 表头操作
 * @param table
 */
function toolClazzInfoBar(table) {
    table.on('toolbar(clazzInfoLayFilter)', function (obj) {
        if ('saveClazzInfo' === obj.event) {
            $.flyer.openIframe({
                title: '新增',
                content: clazzPath + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function toolClazzInfo(table) {
    table.on('tool(clazzInfoLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteClazz' === obj.event) {
            $.table.delete({
                url: clazzPath + '/' + data.id,
                title: data.title,
                reloadTable: reloadClazzTableData
            })
        }
        if ('updateClazz' === obj.event) {
            $.flyer.openIframe({
                title: '编辑',
                content: clazzPath + '/edit/' + data.id
            })
        }

        if ('auzClazz' === obj.event) {
            let uri = HTTP_BIZ_URI + '/admin/auth/clazz/menu/' + data.id + '/index';
            $.flyer.full('岗位权限', uri)
        }

        if ('viewClazz' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看',
                content: clazzPath + '/view/' + data.id
            })
        }
    })
}


// function queryClazzInfoWhere() {
//     let title = $('#title').val();
//     let validFlag = $('#validFlag').val();
//     return {
//         title: title,
//         validFlag: validFlag
//     }
// }


function tableInitClazzOptions(params={}) {
    return {
        id: 'clazzInfoLayTable',
        elem: '#clazzInfoLayTable',
        layFilter: 'clazzInfoLayFilter',
        toolbar: '#clazzInfoToolbar',
        url: clazzPath + "/page",
        where: params,
        cols: [[
            {field: 'thatLevelTitle', title: '岗位等级', width: 320, align: "center"},
            {field: 'title', title: '岗位名称', width: 320, align: "center"},
            {field: 'remarks', title: '备注', align: "center"},
            {field: 'validFlag', title: '有效标志', width: 180, align: "center", templet: "#validClazzFlagTpl"},
            {fixed: 'right', title: '操作', toolbar: '#toolClazzInfoActionBar', width: 450, align: "center"}
        ]]
    }
}

/**
 * 更新有效标志状态
 * @param table
 * @param id
 * @param checked
 */
function validFlagClazzInfoFilter(table, id, checked) {
    $.http.post({
        url: clazzPath + '/' + id + '/valid/' + checked,
        callback: function (res) {
            $.msg.msgSuccess('有效标志更改成功！');
        },
        errCallback: function (err) {
            reloadClazzTableData(table);
            $.msg.msgWarning(err.msg);
        }
    })
}


