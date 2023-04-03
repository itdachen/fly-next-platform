var columns = [];
layui.use(['table', 'form'], function () {
    let table = layui.table;
    let form = layui.form;
    form.render();

    initDict()

    let tableId = $('#id').val();
    getObjData(table, tableId, form);


    form.on('switch(isPkFilter)', function (obj) {
        columnFilter(this.value, obj.elem.checked, this.name);
    });
    form.on('switch(isDtoVoFilter)', function (obj) {
        columnFilter(this.value, obj.elem.checked, this.name);
    });
    form.on('switch(isFormFilter)', function (obj) {
        columnFilter(this.value, obj.elem.checked, this.name);
    });
    form.on('switch(isRequiredFilter)', function (obj) {
        columnFilter(this.value, obj.elem.checked, this.name);
    });
    form.on('switch(isListFilter)', function (obj) {
        columnFilter(this.value, obj.elem.checked, this.name);
    });
    form.on('switch(isQueryFilter)', function (obj) {
        columnFilter(this.value, obj.elem.checked, this.name);
    });
    form.on('select', function (obj) {
        console.log('queryTypeFilter', obj)
    })

    /* 提交 */
    form.on('submit(editTableInfo)', function (data) {
        let obj = data.field;
        assignmentField(obj);
        obj.columns = columns;
        console.log(obj)
        $.form.submit({
            url: HTTP_BIZ_URI + '/tools/table/info/' + data.field.id,
            data: obj,
            callback: function (res) {
                layer.alert(res.msg, {title: "系统提示", icon: 1}, function () {
                    goBackPreviousPage();
                });
            }
        })
    });

});

function getObjData(table, tableId, form) {
    $.ajax({
        url: HTTP_BIZ_URI +  '/tools/table/info/' + tableId,
        success: function (res) {
            if (200 === res.status) {
                initForm(res.data, form)
                columns = res.data.columns;
                table.render(tableOptions(columns));

                form.render();
            } else {
                layer.alert('获取数据失败', {title: "系统提示", icon: 2});
            }
        }
    })
}

function initForm(data, form) {
    $("#tableName").val(data.tableName);
    $("#tableComment").val(data.tableComment);
    $("#className").val(data.className);
    $("#packageName").val(data.packageName);
    $("#moduleName").val(data.moduleName);
    $("#businessName").val(data.businessName);
    $("#functionName").val(data.functionName);
    $("#functionAuthor").val(data.functionAuthor);
    $("#menuId").val(data.menuId);
    $("#menuName").val(data.menuName);
    $("#remark").val(data.remark);

    let tpl = ['biz', 'default'];
    let tplCategory = data.tplCategory;
    let html = '';
    for (let i = 0; i < tpl.length; i++) {
        html = '<input type="radio" name="tplCategory" value="' + tpl[i] + '" title="' + tpl[i] + '"';
        if (tplCategory === tpl[i]) {
            html += 'checked=""'
        }
        html += '>'
        $("#tplCategoryBlock").append(html)
    }

    form.render();
}

function tableOptions(data) {
    return {
        id: 'layTableInfo',
        elem: '#layTable',
        cellMinWidth: 80,
        page: false,
        data: data,
        limit: 1000,
        cols: [[
            {
                field: 'columnName', title: '表字段', align: "center", width: 130, templet: function (d) {
                    return d.columnName + '</br>(' + d.columnType + ')';
                }
            },
            {field: 'columnComment', title: '字段描述', align: "center", edit: 'text'},
            {field: 'javaField', title: 'JAVA类型', align: "center", edit: 'text'},
            {
                field: 'javaType', title: '实体类字段', align: "center", width: 140, templet: function (d) {
                    return selectHtmlTemplate(d.id, d.javaType, 'javaType')
                }
            },
            {field: 'isPk', title: '是否主键', align: "center", templet: '#isPkTpl', width: 90},
            {field: 'isDtoVo', title: '是否Dto/</br>Vo字段', align: "center", templet: '#isDtoVoTpl', width: 90},
            {field: 'isForm', title: '是否</br>表单字段', align: "center", templet: '#isFormTpl', width: 90},
            {field: 'isRequired', title: '是否</br>必填', align: "center", templet: '#isRequiredTpl', width: 90},
            {field: 'isList', title: '是否</br>列表字段', align: "center", templet: '#isListTpl', width: 90},
            {field: 'isQuery', title: '是否</br>查询字段', align: "center", templet: '#isQueryTpl', width: 90},
            {
                field: 'queryType', title: '查询方式', align: "center", width: 130, templet: function (d) {
                    return selectHtmlTemplate(d.id, d.queryType, 'queryType')
                }
            },
            {
                field: 'htmlType', title: '显示类型', align: "center", width: 130, templet: function (d) {
                    return selectHtmlTemplate(d.id, d.htmlType, 'htmlType')
                }
            },
            {
                field: 'dictType', title: '字典类型', align: "center", width: 130, templet: function (d) {
                    return selectHtmlTemplate(d.id, d.dictType, 'dictType')
                }
            },
            {field: 'sort', title: '排序', align: "center", edit: 'text', width: 60},
        ]],
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
}
