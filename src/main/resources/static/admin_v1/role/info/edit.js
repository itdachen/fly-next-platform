layui.use(['form'], function () {
    let form = layui.form;
    form.render();
        

    /* 提交 */
    form.on('submit(editRoleInfo)', function (data) {
        $.form.submit({
            url: '/admin/role/info/' + data.field.id,
            data: data.field
        })
    });

});
