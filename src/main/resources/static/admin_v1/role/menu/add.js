layui.use(['form'], function () {
    let form = layui.form;
    form.render();
    


    /* 提交 */
    form.on('submit(saveRoleMenu)', function (data) {
        $.form.submit({
            url: '/admin/role/menu',
            data: data.field,
        })
    });

});
