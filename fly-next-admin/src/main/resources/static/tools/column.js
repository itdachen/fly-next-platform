layui.use(['form'], function () {
    let form = layui.form;
    form.render();

    /* java 类型 */
    $.form.selectOption(form, {
        id: 'javaType',
        keyId: 'value',
        keyName: 'label',
        data: javaType(),
        placeholder: "请选择JAVA类型",
        value: 'String'
    })

    /* html 显示类型 */
    $.form.selectOption(form, {
        id: 'htmlType',
        keyId: 'value',
        keyName: 'label',
        data: htmlType(),
        placeholder: "请选择显示类型",
        value: 'input'
    })

    /* 查询方式 */
    $.form.selectOption(form, {
        id: 'queryType',
        keyId: 'value',
        keyName: 'label',
        data: queryType(),
        placeholder: "请选择查询方式",
        value: 'EQ'
    })


    /* 数据字典 */
    $.form.selectHttpOption(form, {
        url: DICT_PATH,
        id: 'dictType',
        keyId: 'id',
        keyName: 'name',
        placeholder: "请选择数据字典"
    })


    /* 提交 */
    form.on('submit(addColumnInfo)', function (data) {
        $.http.post({
            url: HTTP_BIZ_URI + '/tools/table/info/save/column',
            data: data.field,
            callback: function (res) {
                layer.alert(res.msg, {title: "系统提示", icon: 1}, function () {
                    goBackPreviousPage();
                });
            }
        })
    });

});