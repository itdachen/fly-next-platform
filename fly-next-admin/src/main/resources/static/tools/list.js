/*
  +++++++++++++++++++++++++++++++++++++++++++
  +  Description: 代码生成业务表
  +  Created by 王大宸 on 2022-08-11 09:15:25
  +  Created with IntelliJ IDEA.
  ++++++++++++++++++++++++++++++++++++++++++++
 */
const path = HTTP_BIZ_URI + "/tools/table/info";
layui.use(['table', 'laypage'], function () {
    let table = layui.table;

    // 创建渲染实例
    let obj = options;
    obj.cols = [[
        {type: 'checkbox'},
        {field: 'tableName', title: '表名称', align: "center"},
        {field: 'tableComment', title: '表描述', align: "center"},
        {fixed: 'right', title: '操作', toolbar: '#toolbarHandle', align: "center"}
    ]];
    obj.where = queryWhere();
    obj.url = path + "/db/list";
    obj.id = 'layTableInfo';
    obj.elem = '#layTable';
    obj.toolbar = '#toolbarDemo';
    table.render(obj);

    // 搜索条件
    $('#searchBtn').on('click', function () {
        reloadTableData(table);
    })

    //触发单元格工具事件
    table.on('tool(layTableFilter)', function (obj) {
        let data = obj.data;
        if (obj.event === 'import') {
            importDb(data.tableName);
        }
    });


    $('#btn_generate').on('click', function () {
        let checkStatus = table.checkStatus('layTableInfo');
        let data = checkStatus.data;
        if (data.length === 0) {
            layer.alert("请选择需要的表", {
                time: 5000,
                btn: ['确定'],
                icon: 0
            });
            return false;
        }
        let tableNames = [];
        for (let i = 0; i < data.length; i++) {
            tableNames.push(data[i].tableName);
        }
        importDb(tableNames.join());
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


function importDb(tableNames) {
    $.ajax({
        type: 'POST',
        url: path + "/import/db?tableNames=" + tableNames,
        success: function (res) {
            if (200 === res.status) {
                layer.alert('导入成功', {title: "系统提示", icon: 1}, function () {
                    goBackPreviousPage();
                });
            } else {
                layer.alert('导失败', {title: "系统提示", icon: 2});
            }
        }
    })
}

/**
 * 数据重新加载
 * @param table
 */
function reloadTableData(table) {
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
    $.model.openIframe({
        title: '新增代码生成业务表',
        content: path + '/import/index'
    })
}

