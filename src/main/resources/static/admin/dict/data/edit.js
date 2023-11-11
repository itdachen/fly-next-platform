layui.use(['form'], function () {
    let form = layui.form;
    form.render();
              

    /* 提交 */
    form.on('submit(editDictData)', function (data) {
        $.form.submit({
            url: '/admin/dict/data/' + data.field.id,
            data: data.field
        })
    });

});
