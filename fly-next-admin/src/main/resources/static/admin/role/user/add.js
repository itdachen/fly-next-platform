layui.use(['form'], function () {
    let form = layui.form;
    form.render();
    


    /* 提交 */
    form.on('submit(saveRoleUser)', function (data) {
        $.form.submit({
            url: '/admin/role/user',
            data: data.field,
        })
    });

});
