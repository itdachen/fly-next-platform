layui.use(['form'], function () {
    let form = layui.form;
    form.render();
          


    /* 提交 */
    form.on('submit(saveDeptInfo)', function (data) {
        $.form.submit({
            url: '/admin/dept/info',
            data: data.field,
        })
    });

});
