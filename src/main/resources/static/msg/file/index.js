/*
 ++++++++++++++++++++++++++++++++++
 + 消息附件
 + @author 王大宸
 + @date 2025-07-11 22:52:18
 ++++++++++++++++++++++++++++++++++
 */
var MSG_FILE_PATH = HTTP_BIZ_URI + '/msg/file';
layui.use(['table', 'form'],  function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    /* 初始化表格 */
    initMsgFileLayTable(table,form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initMsgFileLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, msgFileTableOptions({}));

    /* 表头事件监听 */
    msgFileToolBar(table);

    /* 操作栏监听 */
    msgFileActionBar(table);

    /* 导出 */
    form.on('submit(expMsgFile)', function (data) {
        let uri = queryUriObjParams(MSG_FILE_PATH + '/exp', data.field)
        window.open(uri);
        return false;
    })

    /* 查询 */
    form.on('submit(queryMsgFile)', function (data) {
        reloadMsgFileTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
           // event.preventDefault();
           // let obj = $.form.getFormValue('queryMsgFile')
            reloadMsgFileTableData(table)
            return false;
        }
    })

}

/**
 * 表头操作
 * @param table
 */
function msgFileToolBar(table) {
    table.on('toolbar(msgFileLayFilter)', function (obj) {
        if ('saveMsgFile' === obj.event) {
            $.flyer.openIframe({
                title: '新增消息附件',
                content: MSG_FILE_PATH + '/add'
            })
        }
    })
}

/**
 * 表格操作
 * @param table
 */
function msgFileActionBar(table) {
    table.on('tool(msgFileLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteMsgFile' === obj.event) {
            $.table.delete({
                url: MSG_FILE_PATH + '/' + data.id,
                title: data.name,
                reloadTable: reloadMsgFileTableData
            })
        }
        if ('updateMsgFile' === obj.event) {
            $.flyer.openIframe({
                title: '编辑消息附件',
                content: MSG_FILE_PATH + '/edit/' + data.id
            })
        }
        if ('viewMsgFile' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看消息附件',
                content: MSG_FILE_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadMsgFileTableData(table) {
    let queryMsgFileParams = $.form.getFormValue('queryMsgFileForm')
    $.table.reloadData(table, msgFileTableOptions(queryMsgFileParams));
}

/**
 * 表格参数
 */
function msgFileTableOptions(queryMsgFileParams) {
    return {
        id: 'msgFileLayTable',
        elem: '#msgFileLayTable',
        toolbar: '#msgFileToolBar',  // 不展示表头设置成 false
        layFilter: 'msgFileLayFilter',
        url: MSG_FILE_PATH + '/page',
        where: queryMsgFileParams,
        cols: [[
                    {field: 'fileTitle', title: '文件名称', align: 'center'},
                    {field: 'fileFormat', title: '文件格式', align: 'center'},
                    {field: 'hexMd5', title: '文件MD5值(对接文件服务, 真多同一个文件同时上传多次的问题, MD5 可以实现秒传)', align: 'center'},
                    {field: 'downloadFlag', title: '下载标志', align: 'center'},
                    {field: 'downloadTotal', title: '下载次数', align: 'center'},
                    {field: 'readFlag', title: '阅读标志', align: 'center'},
                    {field: 'readTime', title: '阅读时间', align: 'center'},
                    {field: 'createTime', title: '创建时间', align: 'center'},
            {fixed: 'right', title: '操作', toolbar: '#msgFileActionBar', width: 320, align: 'center'}
        ]]
    }

}

