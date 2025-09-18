/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 菜单信息
  +  Created by 王大宸 on 2024-04-20 22:25:57
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/menu/info";
layui.use(function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    flyMenuParentId = $('#appId').val();

    initTree(table);

    initLayTable(table, form);

});

/**
 * 加载菜单树
 */
function initTree(table) {
    let appId = $('#appId').val();
    $.zTree.initTree({
        id: 'menuIndexTree',
        url: path + '/' + appId + "/tree",
        callback: function (event, treeId, treeNode) {
            flyMenuParentId = treeNode.id;
            if ('menu' === treeNode.type) {
                $('#menuTableBox').attr('style', 'display:none')
                $('#elementTableBox').attr('style', 'display:block')
                reloadTableElementData(table, {});
                return false;
            } else {
                $('#menuTableBox').attr('style', 'display:block')
                $('#elementTableBox').attr('style', 'display:none')
                $('#headBarTool').attr('style', 'display:block')
                reloadTableData(table, {})
            }

            if ('1' === flyMenuParentId) {
                $('#headBarTool').attr('style', 'display:none')
            }

        }
    })
}

/****** 菜单 START *********************************************************************************************/

function initLayTable(table, form) {
    let appId = $('#appId').val();
    /* 初始化表格 */
    $.table.init(table, tableInitOptions({appId: appId, parentId: appId}))

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    /* 导出 */
    form.on('submit(expMenuInfo)', function (data) {
        let uri = queryUriObjParams(path + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryMenuInfo)', function (data) {
        reloadTableData(table, data.field)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            event.preventDefault();
            let obj = $.form.getFormValue('queryMenuInfo')
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
function reloadTableData(table, params = {}) {
    params.appId = $('#appId').val();
    params.parentId = flyMenuParentId;
    $.table.reloadData(table, tableInitOptions(params));
}


/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if ('saveMenuInfo' === obj.event) {
            let appId = $('#appId').val();
            $.model.openIframe({
                title: '新增',
                content: path + '/' + appId + '/add/' + flyMenuParentId
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
            {field: 'title', title: '菜单标题', align: "center"},
            {field: 'authCode', title: '认证编码', align: "center"},
            {
                field: 'type', title: '类型', align: "center", templet: function (d) {
                    if ('uri' === d.type) {
                        return '链接';
                    }
                    if ('dirt' === d.type) {
                        return '目录';
                    }
                    if ('menu' === d.type) {
                        return '菜单';
                    }
                }
            },
            //  {field: 'askUri', title: '访问地址', align: "center"},
            {field: 'path', title: '访问地址', align: "center"},
            {field: 'orderNum', title: '排序', align: "center"},
            {
                field: 'validFlag', title: '有效标志', align: "center", templet: "#validFlagTpl"
            },
            // {field: 'openType', title: '菜单打开方式', align: "center"},
            // {field: 'hasAuth', title: '是否需要授权: Y-需要;N-不需要', align: "center"},
            // {field: 'hasIp', title: '是否需要白名单IP: Y-需要;N-不需要', align: "center"},
            // {field: 'thirdParty', title: '第三方平台标识', align: "center"},
            // {field: 'thirdTitle', title: '第三方平台名称', align: "center"},
            // {field: 'thirdUri', title: '第三方基础访问地址, 例如: http://www.baidu.com', align: "center"},
            // {field: 'askUri', title: '最终访问地址, 根据第三方平台信息拼接', align: "center"},
            // {field: 'componentName', title: '组件名称', align: "center"},
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

/****** 菜单 END *********************************************************************************************/
