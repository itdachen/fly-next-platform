layui.use(['form'], function () {
    let form = layui.form;
    form.render();
    

    /* 提交 */
    form.on('submit(editRoleUser)', function (data) {
        $.form.submit({
            url: '/admin/role/user/' + data.field.id,
            data: data.field
        })
    });

});
