layui.use(['form'], function () {
    let form = layui.form;
    form.render();
                


    /* 提交 */
    form.on('submit(saveDictData)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/dict/data' ,
            data: data.field
        })
    });

});
