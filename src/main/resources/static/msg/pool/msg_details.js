/**
 * 消息详情
 */
layui.use(function () {
    let table = layui.table;
    let form = layui.form;


    let msgId = $('#msgId').val();
    $.http.get({
        url: HTTP_BIZ_URI + '/msg/pool/info/' + msgId,
        callback: function (res) {
            console.log(res);

            let data = res.data;


            $('#msgTitle').html('');
            $('#msgTitle').html(data.title);
            $('#msgTime').html('');
            $('#msgTime').html(data.createTime);


            $('#content').html('');
            $('#content').html(data.content);


            $.table.init(table, messageInfoTableOptions(data.files));

            toolMessageInfo(table);

        }
    })


})


/**
 * 表格操作
 * @param table
 */
function toolMessageInfo(table) {
    table.on('tool(layMessageInfoFilter)', function (obj) {
        let data = obj.data;
        if ('download' === obj.event) {
            downloadExpFile(data.fileUri, data.fileTitle);

        }
    })
}


function messageInfoTableOptions(data) {
    return {
        id: 'layMessageInfoTable',
        elem: '#layMessageInfoTable',
        layFilter: 'layMessageInfoFilter',
        toolbar: false,
        page: {
            theme: '#1E9FFF',
            groups: 5,
            limits: [10, 15, 30, 50, 100],
            layout: ['prev', 'page', 'next', 'limit', 'skip', 'count'],
            prev: '上一页',
            next: '下一页'
        },
        data: data,
        cols: [[
            {field: 'fileTitle', title: '附件名称', align: "left"},
            {
                field: 'downloadFlag', title: '是否已下载', width: 200,
                align: 'center', templet: function (d) {
                    return 'Y' === d.downloadFlag ? '已下载' : '未下载'
                }
            },
            {field: 'downloadTotal', title: '下载数量', width: 180, align: 'center'},
            // {field: 'fileSize', title: '文件大小', width: 180, align: 'center'},
            {fixed: 'right', title: '操作', toolbar: '#toolbarMessageInfoHandle', width: 200, align: "center"}
        ]]
    }
}


/**
 * 下载文件, 需要注意一点, 跨域问题
 * @param url
 * @param fileName
 */
function downloadExpFile(url, fileName) {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.responseType = 'blob';
    xhr.onload = function () {
        const blob = xhr.response;
        const link = document.createElement('a');
        link.href = URL.createObjectURL(blob);
        link.download = fileName;
        link.target = "_blank"; // 可选，如果希望在新窗口中下载文件，请取消注释此行
        link.click();
    };
    xhr.send();
}
