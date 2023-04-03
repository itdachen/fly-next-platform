layui.use(['form'], function () {
    let form = layui.form;
    form.render();

    /* 提交 */
    form.on('submit(saveTableInfo)', function (data) {
        $.form.submit({
            url: '/tools/table/info',
            data: data.field,
        })
    });

});
