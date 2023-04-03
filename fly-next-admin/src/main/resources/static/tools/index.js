/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 代码生成业务表
  +  Created by 王大宸 on 2022-08-11 09:15:25
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/tools/table/info";
layui.use(['table', 'laypage'], function () {
    let layTable = layui.table;

    // 创建渲染实例
    let obj = options;
    obj.cols = [[
        {type: 'checkbox'},
        {field: 'tableName', title: '表名称', align: "center"},
        // {field: 'tableComment', title: '表描述', align: "center"},
        {field: 'className', title: '实体类名称', align: "center", header: false},
        {field: 'packageName', title: '生成包路径', align: "center"},
        {field: 'functionName', title: '生成功能名', align: "center"},
        // {field: 'functionAuthor', title: '生成功能作者', align: "center"},
        {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', width: 300, align: "center"}
    ]];
    obj.where = queryWhere();
    obj.url = path + "/page";
    obj.id = 'layTableInfo';
    obj.skin = 'line';
    obj.elem = '#layTable';
    obj.toolbar = '#toolTableBar';
    layTable.render(obj);

    // 搜索条件
    $('#searchBtn').on('click', function () {
        reloadTableData(layTable);
    })

    $('#btnGenCode').on('click', function () {
        let checkStatus = layTable.checkStatus('layTableInfo');
        let data = checkStatus.data;
        if (0 === data.length) {
            layer.alert("请选择需要的表", {
                time: 5000,
                btn: ['确定'],
                icon: 0
            });
            return false;
        }
        let tableNames = [];
        for (let i = 0; i < data.length; i++) {
            tableNames.push(data[i].id);
        }
        location.href = path + "/code?id=" + tableNames.join();
    });

    // 触发单元格工具事件
    layTable.on('tool(layTableFilter)', function (obj) {
        let data = obj.data;
        switch (obj.event) {
            case 'del':
                layer.confirm('<div style="color: #ff000c">确定删除该数据吗?</div>', {
                    icon: 3,
                    title: '系统提示！'
                }, function () {
                    $.ajax({
                        type: 'DELETE',
                        url: path + '/' + data.id,
                        success: function (res) {
                            if (200 === res.status) {
                                layer.msg('删除成功', {
                                    icon: 1,
                                    time: 1000
                                }, function () {
                                    reloadTableData(layTable)
                                });
                            } else {
                                layer.alert('操作失败', {title: "系统提示", icon: 2});
                            }
                        }
                    })
                });
                break
            case 'edit':
                location.href = path + '/edit/' + data.id;
                break;
            case 'preview':
                layer.open({
                    type: 2,
                    title: '预览',
                    area: ['95%', '80%'],
                    content: path + '/view/' + data.id
                });
                break;
            case 'btnGenerate':
                location.href = path + "/code?id=" + data.id;
                break;
            case 'addColumn':
                location.href = path + '/column/' + data.id;
                break;
            default:
                console.warn('未找到处理事件')

        }
    });

})

/**
 * 数据表格查询条件(必须有,不然表格重载不了)
 */
function queryWhere() {
    let name = $("#name").val();
    return {
        tableName: name
    }
}

/**
 * 数据重新加载
 * @param table
 */
function reloadTableData(table) {
    if (null === table || undefined === table) {
        table = layui.table;
    }
    options.page.curr = 1;
    options.where = queryWhere();
    table.reloadData('layTableInfo', options);
}

const options = {
    id: 'layTableInfo',
    elem: '#layTable',
    defaultToolbar: ['filter', 'exports', 'print'],
    cellMinWidth: 80,
    response: {
        statusName: 'status', //规定数据状态的字段名称，默认：code
        statusCode: 200 //规定成功的状态码，默认：0
    },
    parseData: function (res) { //res 即为原始返回的数据
        return {
            "status": res.status, //解析接口状态
            "msg": res.message, //解析提示文本
            "count": res.data.total, //解析数据长度
            "data": res.data.rows //解析数据列表
        };
    },
    page: {
        theme: '#1E9FFF',
        limits: [10, 15, 30, 50, 100, 500, 10000],
        layout: ['prev', 'page', 'next', 'skip', 'refresh', 'limit', 'count'],
        prev: '上一页',
        next: '下一页'
    },
    done: function (res, curr, count) {
        let x = 10;
        let y = 20;
        let newTitle = '';
        $('td').each(function (index, element) {
            if ($(element).text() !== '' && $(element).text() != null) {
                $(element).attr('title', $(element).text()).addClass('tdTitle');
            }
        });
        $(".layui-table-col-special").removeClass("tdTitle").attr("title", "");
        $('td.tdTitle').mouseover(function (e) {
            newTitle = this.title;
            this.title = '';
            $('body').append('<div id="tooltip">' + newTitle + '</div>');
            $('#tooltip').css({
                'left': (e.pageX + x + 'px'),
                'top': (e.pageY + y + 'px'),
            }).show();
        }).mouseout(function () {
            this.title = newTitle;
            $('#tooltip').remove();
        }).mousemove(function (e) {
            $('#tooltip').css({
                'left': (e.pageX + x + 'px'),
                'top': (e.pageY + y + 'px')
            }).show();
        })
    },
}

/* 添加按钮 */
function saveTableInfo() {
    location.href = path + '/import/index'
}

function addTableInfo(){
    location.href = path + '/save/table'
}
