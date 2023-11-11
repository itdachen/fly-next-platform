layui.use(['form'], function () {
    let form = layui.form;
    form.render();

    /* 提交 */
    form.on('submit(addTableInfo)', function (data) {
        $.http.post({
            url: HTTP_BIZ_URI + '/tools/table/info/save/table',
            data: data.field,
            callback: function (res) {
                layer.alert(res.msg, {title: "系统提示", icon: 1}, function () {
                    goBackPreviousPage();
                });
            }
        })
    });

});