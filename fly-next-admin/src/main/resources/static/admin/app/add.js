layui.use(['form', 'upload'], function () {
    let form = layui.form;
    let upload = layui.upload;
    form.render();

    $.oss.imageUpload(upload, {
        id: 'uploadImage',
        tipsBox: 'imgIcon',
        imageSrc: 'imageSrc',
        fieldName: 'icon',
    })

    /* 提交 */
    form.on('submit(saveAppClient)', function (data) {
        $.form.submit({
            url: '/biz/app/client',
            data: data.field,
            callback: function (res) {
                layer.alert(res.msg, {title: "系统提示", icon: $.msg.icon(LAYER_STATUS.SUCCESS)},
                    function () {
                        goBackPreviousPage();
                    });
            }
        })
    });

});
