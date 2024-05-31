layui.use(['form'], function () {
    let form = layui.form;
    form.render();


    /* 提交 */
    form.on('submit(editDeptType)', function (data) {
        $.form.update({
            url: HTTP_BIZ_URI + '/admin/dept/type',
            data: data.field
        })
    });

});
