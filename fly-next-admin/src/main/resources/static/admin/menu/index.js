/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 菜单管理
  +  Created by 王大宸 on 2023-04-04 21:52:58
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/menu/info";
const elementPath = HTTP_BIZ_URI + '/admin/element/info';
var parentId = 'ROOT';
var elementTable;
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;

    initTree();

    /* 初始化表格 */
    $.table.init(table, options())

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    /* 隐藏新增按钮 */
    if ('ROOT' === parentId || '0' === parentId) {
        $('#headBarTool').attr('style', 'display:none')
    }

    /* 初始化表格 */
    $.table.init(table, elementOptions())

    /* 表头事件监听 */
    toolBarElement(table);

    /* 操作栏监听 */
    toolElement(table);


    // 菜单显示不显示操作
    form.on('switch(menuVisibleFilter)', function (obj) {
        onStatusTpl(this.value, obj.elem.checked, 'menu');
    });

    // 按钮显示不显示操作
    form.on('checkbox(elementVisibleFilter)', function (obj) {
        onStatusTpl(this.value, obj.elem.checked, 'element');
    });

});

/**
 * 数据表格查询条件(必须有,不然表格重载不了)
 */
function queryWhere() {
    let title = $("#title").val();
    return {
        title: title,
        parentId: parentId
    }
}

/**
 * 刷新表格数据
 * @param table
 */
function reloadTableData(table) {
    $.table.reloadData(table, options());
}


/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if ('search' === obj.event) {
            reloadTableData(table);
        }
        if ('saveMenuInfo' === obj.event) {
            $.model.openIframe({
                title: '新增',
                content: path + '/' + parentId + '/add'
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
                title: data.name,
                reloadTable: reloadTreeTable
            })
        }
        if ('update' === obj.event) {
            $.model.openIframe({
                title: '编辑',
                content: path + '/edit/' + data.id
            })
        }
        if ('view' === obj.event) {
            $.model.openIframeSee({
                title: '查看',
                content: path + '/view/' + data.id
            })
        }
    })
}

/**
 * 同时刷新表格和左边的树结构数据
 */
function reloadTreeTable() {
    initTree();
    reloadTableData();
}


function options() {
    return {
        url: path + "/page",
        where: queryWhere(),
        cols: [[
            {field: 'title', title: '标题', align: "center"},
            {field: 'code', title: '权限编码', align: "center"},
            {field: 'path', title: '资源路径', align: "center"},
            {
                field: 'type', title: '类型', align: "center", templet: function (d) {
                    if ('menu' === d.type) {
                        return '菜单';
                    } else {
                        return '目录';
                    }
                }
            },
            {
                field: 'visible',
                title: '是否显示',
                align: "center",
                width: 110,
                templet: '#menuVisibleTpl',
                unresize: true
            },
            {field: 'orderNum', title: '排序', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', width: "20%", align: "center"}
        ]]
    }

}


function initTree() {
    $.zTree.initTree({
        url: path + "/zTree",
        callback: function (event, treeId, treeNode) {
            parentId = treeNode.id;
            if ('menu' === treeNode.type) {
                $('#menuTableBox').attr('style', 'display:none')
                $('#elementTableBox').attr('style', 'display:block')
                reloadElementTableData();
                return false;
            } else {
                $('#menuTableBox').attr('style', 'display:block')
                $('#elementTableBox').attr('style', 'display:none')
                $('#headBarTool').attr('style', 'display:block')
                reloadTableData()
            }
        }
    })
}


/********** 按钮相关操作 ************************************************************/


/**
 * 表头操作
 * @param table
 */
function toolBarElement(table) {
    table.on('toolbar(layElementFilter)', function (obj) {
        if ('search' === obj.event) {
            reloadElementTableData(table);
        }
        if ('saveElement' === obj.event) {
            // let menuId = $("#menuId").val();
            $.model.openIframe({
                title: '新增',
                content: elementPath + '/' + parentId + '/add'
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
                url: elementPath + '/' + data.id,
                title: data.name,
                reloadTable: reloadElementTableData
            })
        }
        if ('update' === obj.event) {
            $.model.openIframe({
                title: '编辑',
                content: elementPath + '/edit/' + data.id
            })
        }
        if ('view' === obj.event) {
            $.model.openIframeSee({
                title: '查看',
                content: elementPath + '/view/' + data.id
            })
        }
    })
}

/**
 * 刷新表格数据
 * @param table
 */
function reloadElementTableData(table) {
    if ($.string.isEmpty(table)) {
        table = layui.table;
    }
    let o = elementOptions();
    let d = $.table.defineProps;
    let p = $.extend({}, d, o);
    p.where = queryElementWhere();
    p.page.curr = 1;
    table.render(p);
    // elementTable.reloadData(p.id, p);
}


function queryElementWhere() {
    let title = $("#elementTitle").val();
    return {
        menuId: parentId,
        title: title
    }
}

function elementOptions() {
    return {
        id: 'layElementTable',
        elem: '#layElementTable',
        toolbar: '#toolbarElement',
        layFilter: 'layElementFilter',
        url: elementPath + "/page",
        where: queryElementWhere(),
        cols: [[
            {field: 'title', title: '资源名称', align: "center"},
            {field: 'code', title: '权限编码', align: "center"},
            {field: 'type', title: '资源类型', align: "center"},
            {
                field: 'visible',
                title: '状态',
                align: "center",
                width: 110,
                templet: '#elementVisibleTpl',
                unresize: true
            },
            {field: 'orderNum', title: '排序', align: "center"},
            {fixed: 'right', title: '操作', toolbar: '#toolbarElementHandle', width: "20%", align: "center"}
        ]]
    }
}

function onStatusTpl(dataId, status, type) {
    let uri = path;
    if ('element' === type) {
        uri = elementPath;
    }
    uri += '/' + dataId + '/status/' + status;
    $.http.put({
        url: uri,
        callback: function (res) {
            if (status) {
                $.msg.msgSuccess('解除冻结成功');
            } else {
                $.msg.msgSuccess('冻结成功');
            }
        },
        errCallback: function (err) {
            reloadTableData();
            $.msg.msgWarning(err.msg);
        }
    })
}

