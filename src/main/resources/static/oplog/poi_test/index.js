/*
 ++++++++++++++++++++++++++++++++++
 + 导入导出测试
 + @author 王大宸
 + @date 2025-07-28 16:55:09
 ++++++++++++++++++++++++++++++++++
 */
var OPLOG_POI_TEST_PATH = HTTP_BIZ_URI + '/oplog/poi/test';
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    let upload = layui.upload;
    form.render();


    upload.render({
        elem: '#impOplogPoiTest', // 绑定多个元素
        url: OPLOG_POI_TEST_PATH + '/imp', // 此处配置你自己的上传接口即可
        accept: 'file', // 普通文件
        done: function (res) {
            // layer.msg('上传成功');
            // console.log(res);
            $.msg.alertMsg(res.msg);
        }
    });

    /* 初始化表格 */
    initOplogPoiTestLayTable(table, form);

});

/**
 * 初始化表格
 * @param table
 * @param form
 */
function initOplogPoiTestLayTable(table, form) {
    /* 初始化表格 */
    $.table.init(table, oplogPoiTestTableOptions({}));

    /* 表头事件监听 */
    oplogPoiTestToolBar(table);

    /* 操作栏监听 */
    oplogPoiTestActionBar(table);

    /* 导出 */
    form.on('submit(expOplogPoiTest)', function (data) {
        let expUri = queryUriObjParams(OPLOG_POI_TEST_PATH + '/exp', data.field)
        //  window.open(uri);
        $.http.get({
            url: expUri,
            callback: function (res) {
                $.msg.alertMsg(res.msg);
            }
        })
        return false;
    })

    /* 查询 */
    form.on('submit(queryOplogPoiTest)', function (data) {
        reloadOplogPoiTestTableData(table)
        return false;
    })

    /* 搜索输入框回车监听 */
    $('.keypress-listen').bind('keypress', function (event) {
        if (13 === event.keyCode || '13' === event.keyCode) {
            // event.preventDefault();
            // let obj = $.form.getFormValue('queryOplogPoiTest')
            reloadOplogPoiTestTableData(table)
            return false;
        }
    })

}

/**
 * 表头操作
 * @param table
 */
function oplogPoiTestToolBar(table) {
    table.on('toolbar(oplogPoiTestLayFilter)', function (obj) {
        if ('saveOplogPoiTest' === obj.event) {
            $.flyer.openIframe({
                title: '新增导入导出测试',
                content: OPLOG_POI_TEST_PATH + '/add'
            })
        }
        if ('impOplogPoiImpTmp' === obj.event) {

            let impOplogPoiImpTmpURI = HTTP_BIZ_URI + '/static/oplog/poi_test/导入测试模板.xlsx'
            //  let impOplogPoiImpTmpURI = 'http://127.0.0.1:8085/fly/static/oplog/poi_test/导入测试模板.xlsx'
            //   downloadFile(impOplogPoiImpTmpURI, '导入测试模板.xlsx')


            // downLoadFile2(impOplogPoiImpTmpURI, '导入测试模板.xlsx');


            $.oss.download({
                uri: impOplogPoiImpTmpURI,
                fileName: '导入测试模板.xlsx'
            })

        }


    })
}

/**
 * 表格操作
 * @param table
 */
function oplogPoiTestActionBar(table) {
    table.on('tool(oplogPoiTestLayFilter)', function (obj) {
        let data = obj.data;
        if ('deleteOplogPoiTest' === obj.event) {
            $.table.delete({
                url: OPLOG_POI_TEST_PATH + '/' + data.id,
                title: data.name,
                reloadTable: reloadOplogPoiTestTableData
            })
        }
        if ('updateOplogPoiTest' === obj.event) {
            $.flyer.openIframe({
                title: '编辑导入导出测试',
                content: OPLOG_POI_TEST_PATH + '/edit/' + data.id
            })
        }
        if ('viewOplogPoiTest' === obj.event) {
            $.flyer.openIframeSee({
                title: '查看导入导出测试',
                content: OPLOG_POI_TEST_PATH + '/view/' + data.id
            })
        }
    })
}


/**
 * 刷新表格数据
 * @param table
 */
function reloadOplogPoiTestTableData(table) {
    let queryOplogPoiTestParams = $.form.getFormValue('queryOplogPoiTestForm')
    $.table.reloadData(table, oplogPoiTestTableOptions(queryOplogPoiTestParams));
}

/**
 * 表格参数
 */
function oplogPoiTestTableOptions(queryOplogPoiTestParams) {
    return {
        id: 'oplogPoiTestLayTable',
        elem: '#oplogPoiTestLayTable',
        toolbar: '#oplogPoiTestToolBar',  // 不展示表头设置成 false
        layFilter: 'oplogPoiTestLayFilter',
        url: OPLOG_POI_TEST_PATH + '/page',
        where: queryOplogPoiTestParams,
        cols: [[
            {field: 'title', title: '日志标题', align: 'center'},
            {field: 'type', title: '日志类型', align: 'center'},
            {field: 'hostIp', title: '操作IP地址', align: 'center'},
            {field: 'hostOs', title: '操作系统', align: 'center'},
            {field: 'hostBrowser', title: '操作浏览器', align: 'center'},
            {field: 'userAgent', title: '用户代理', align: 'center'},
            {field: 'createTime', title: '创建时间', align: 'center'},
            // {fixed: 'right', title: '操作', toolbar: '#oplogPoiTestActionBar', width: 320, align: 'center'}
        ]]
    }

}


function downloadFile(uri, filename) {

}


/**
 * 根据文件路径下载文件，并重命名
 * @param filePath 服务器文件路径
 * @param fileName  重命名                                                                                                                                     11111
 */
function downLoadFile2(filePath, fileName) {
    fetch(filePath).then((response) => response.blob())
        .then((res) => {
            let blob = new Blob([res])
            let link = document.createElement('a');//创建a标签
            link.href = window.URL.createObjectURL(blob);//获得一个http格式的url路径
            link.download = fileName;//下载文件 并重命名
            link.click();
        })
}