layui.use(['form'], function () {
    let form = layui.form;
    form.render();
      


    /* 提交 */
    form.on('submit(saveDeptType)', function (data) {
        $.form.save({
            url: HTTP_BIZ_URI + '/admin/dept/type' ,
            data: data.field
        })
    });

});
