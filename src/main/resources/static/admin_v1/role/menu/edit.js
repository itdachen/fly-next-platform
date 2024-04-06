layui.use(['form'], function () {
    let form = layui.form;
    form.render();
    

    /* 提交 */
    form.on('submit(editRoleMenu)', function (data) {
        $.form.submit({
            url: '/admin/role/menu/' + data.field.id,
            data: data.field
        })
    });

});
