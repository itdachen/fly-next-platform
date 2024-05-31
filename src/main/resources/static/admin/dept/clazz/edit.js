layui.use(['form'], function () {
    let form = layui.form;
    form.render();
          

    /* 提交 */
    form.on('submit(editClazzDept)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/clazz/dept/' + data.field.id,
            data: data.field
        })
    });

});
