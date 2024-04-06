/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 应用
  +  Created by 王大宸 on 2022-08-20 22:27:58
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/admin/app/client";
layui.use(['table'], function () {
    let table = layui.table;
    let form = layui.form;

    /* 初始化表格 */
    $.table.init(table, options())

    /* 表头事件监听 */
    toolBar(table);

    /* 操作栏监听 */
    tool(table);

    // 锁定操作
    form.on('checkbox(stateFilter)', function (obj) {
        onStatusTpl(this.value, obj.elem.checked);
    });

    /* 查询按钮 */
    form.on('submit(queryAppClient)', function (data) {
        console.log(data.field)
        reloadTableData(table);
        return false; // 阻止默认 form 跳转
    });

    /* 导出 */
    form.on('submit(exportAppClient)', function (data) {
        location.href = path + '/export'
        return false; // 阻止默认 form 跳转
    })

});

/**
 * 数据表格查询条件(必须有,不然表格重载不了)
 */
function queryWhere() {
    return {
        appTitle: $("#appTitle").val(),
        appType: $("#appType").val()
    }
}

/**
 * 刷新表格数据
 * @param table
 */
function reloadTableData(table) {
    $.table.reloadTableData(table);
}

/**
 * 表头操作
 * @param table
 */
function toolBar(table) {
    table.on('toolbar(layFilter)', function (obj) {
        if (obj.event === 'search') {
            reloadTableData(table);
        }
        if (obj.event === 'saveAppClient') {
            location.href = path + '/add';
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
        switch (obj.event) {
            case 'delete':
                $.table.delete({
                    url: path + '/' + data.id,
                    title: data.name,
                    reloadTable: reloadTableData(table)
                })
                break;
            case 'update':
                location.href = path + '/edit/' + data.id;
                break;
            case 'view':
                location.href = path + '/view/' + data.id;
                break;
            case 'openIcon':
                if (!$.string.isEmpty(data.icon)) {
                    $.model.openImg(data.name, data.icon, '500', '500');
                }
                break;
            default:
                console.warn('未找到处理事件')
        }


        // if ('del' === obj.event) {
        //     $.table.delete({
        //         url: path + '/' + data.id,
        //         title: data.name,
        //         reloadTable: reloadTableData(table),
        //     })
        // }
        // if ('update' === obj.event) {
        //     location.href = path + '/edit/' + data.id
        // }
        // if ('see' === obj.event) {
        //     location.href = path + '/see/' + data.id
        // }
        // if ('openIcon' === obj.event) {
        //     if (!$.string.isEmpty(data.icon)) {
        //         $.model.openImg(data.name, data.icon, '500', '500');
        //     }
        // }
    })
}

function options() {
    return {
        url: path + "/page",
        where: queryWhere(),
        skin: 'grid',
        cols: [[
            {field: 'appTitle', title: '应用名称', align: "center"},
            {field: 'appCode', title: '应用标识码', align: "center"},
            {field: 'appType', title: '应用类型', align: "center"},
            // {field: 'askUri', title: '互联网访问地址', align: "center"},
            // {field: 'lanUri', title: '内网访问地址', align: "center"},
            {
                field: 'icon', title: '图标', align: "center", templet: function (d) {
                    if ($.string.isNotEmpty(d.icon)) {
                        return '<img style="width:50px;height:50px;cursor:pointer;border-radius: 50%;" src="' + d.icon + '" />';
                    } else {
                        return '';
                    }
                }
            },
            {field: 'status', title: '是否启用', align: "center", width: 110, templet: '#stateTpl', unresize: true},
            {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', width: "20%", align: "center"}
        ]],
        done: function (res, curr, count) {
            $.table.textTips();
            // 合并字段属性
            alarmTableRowSpan('appTitle', 1);
            alarmTableRowSpan('appCode', 1);
        },
    }
}

function onStatusTpl(dataId, status) {
    $.http.put({
        url: path + '/' + dataId + '/status/' + status,
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
