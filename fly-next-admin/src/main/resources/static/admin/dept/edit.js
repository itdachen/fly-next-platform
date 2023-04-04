layui.use(['form'], function () {
    let form = layui.form;
    form.render();
          

    /* 提交 */
    form.on('submit(editDeptInfo)', function (data) {
        $.form.submit({
            url: '/admin/dept/info/' + data.field.id,
            data: data.field
        })
    });

});
