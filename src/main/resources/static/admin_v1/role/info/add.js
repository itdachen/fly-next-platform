layui.use(['form'], function () {
    let form = layui.form;
    form.render();
        


    /* 提交 */
    form.on('submit(saveRoleInfo)', function (data) {
        $.form.submit({
            url: '/admin/role/info',
            data: data.field,
        })
    });

});
