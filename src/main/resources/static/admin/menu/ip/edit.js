layui.use(['form'], function () {
    let form = layui.form;
    form.render();
                                

    /* 提交 */
    form.on('submit(editWhiteIpList)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/white/ip/list/' + data.field.id,
            data: data.field
        })
    });

});
