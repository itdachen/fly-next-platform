layui.use(['form'], function () {
    let form = layui.form;
    form.render();
        

    /* 提交 */
    form.on('submit(editDictType)', function (data) {
        $.form.submit({
            url: '/admin/dict/type/' + data.field.id,
            data: data.field
        })
    });

});
