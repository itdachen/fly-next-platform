layui.use(['form'], function () {
    let form = layui.form;
    form.render();
              

    /* 提交 */
    form.on('submit(editPlatformInfo)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/platform/info/' + data.field.id,
            data: data.field
        })
    });

});
