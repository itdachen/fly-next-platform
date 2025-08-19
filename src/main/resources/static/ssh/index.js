/*
 ++++++++++++++++++++++++++++++++++
 + SSH 连接
 + @author 王大宸
 + @date 2025-08-18 22:58:10
 ++++++++++++++++++++++++++++++++++
 */
var SSH_SERVER_CONFIG_PATH = HTTP_BIZ_URI + '/ssh/server';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initSshServerConfigLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initSshServerConfigLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, sshServerConfigTableOptions({}));

    /* 表头事件监听 */
    sshServerConfigToolBar(table);

    /* 操作栏监听 */
    sshServerConfigActionBar(table);

    /* 导出 */
    form.on('submit(expSshServerConfig)', function (data) {
        let expUri = queryUriObjParams(SSH_SERVER_CONFIG_PATH + '/exp', data.field)
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
    form.on('submit(querySshServerConfig)', function (data) {
        reloadSshServerConfigTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            // event.preventDefault();
            // let obj = $.form.getFormValue('querySshServerConfig')
            reloadSshServerConfigTableData(table)
            return false;
        }
    })

}

/**
 * 表头操作
 * @param table
 */
function sshServerConfigToolBar(table) {
    table.on('toolbar(sshServerConfigLayFilter)', function (obj) {
        if ('saveSshServerConfig' === obj.event) {
            $.flyer.openIframe({
                title: '新增SSH 连接',
                content: SSH_SERVER_CONFIG_PATH + '/add'
            })
        }

        if ('sshServerLink' === obj.event) {
            $.flyer.full(
                '新增SSH 连接',
                SSH_SERVER_CONFIG_PATH + '/webssh'
            )
        }


    })
}

/**
 * 表格操作
 * @param table
 */
function sshServerConfigActionBar(table) {
    table.on('tool(sshServerConfigLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteSshServerConfig' === obj.event) {
            $.table.delete({
                url: SSH_SERVER_CONFIG_PATH + '/' + data.id,
                title: data.name,
                reloadTable: reloadSshServerConfigTableData
            })
        }
        if ('updateSshServerConfig' === obj.event) {
            $.flyer.openIframe({
                title: '编辑SSH 连接',
                content: SSH_SERVER_CONFIG_PATH + '/edit/' + data.id
            })
        }
        if ('viewSshServerConfig' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看SSH 连接',
                content: SSH_SERVER_CONFIG_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadSshServerConfigTableData(table) {
    let querySshServerConfigParams = $.form.getFormValue('querySshServerConfigForm')
    $.table.reloadData(table, sshServerConfigTableOptions(querySshServerConfigParams));
}

/**
 * 表格参数
 */
function sshServerConfigTableOptions(querySshServerConfigParams) {
    return {
        id: 'sshServerConfigLayTable',
        elem: '#sshServerConfigLayTable',
        toolbar: '#sshServerConfigToolBar',  // 不展示表头设置成 false
        layFilter: 'sshServerConfigLayFilter',
        url: SSH_SERVER_CONFIG_PATH + '/page',
        where: querySshServerConfigParams,
        cols: [[
            {field: 'sshTitle', title: '名称', align: 'center'},
            {field: 'hostIp', title: '连接IP', align: 'center'},
            {field: 'hostPort', title: '连接端口', align: 'center'},
            {
                field: 'validFlag', title: '有效标志', align: 'center', templet(d) {
                    if ('Y' === d.validFlag) {
                        return '有效'
                    }
                    return '无效';
                }
            },
            {fixed: 'right', title: '操作', toolbar: '#sshServerConfigActionBar', width: 450, align: 'center'}
        ]]
    }

}

