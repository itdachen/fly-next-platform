layui.use(['form', 'upload'], function () {
    let form = layui.form;
    let upload = layui.upload;
    form.render();

    let icon = $('#icon').val();
    $.oss.imageUpload(upload, {
        id: 'uploadImage',
        tipsBox: 'imgIcon',
        imageSrc: 'imageSrc',
        fieldName: 'icon',
        uri: icon
    })

    /* 提交 */
    form.on('submit(editAppClient)', function (data) {
        $.form.submit({
            url: '/admin/app/client/' + data.field.id,
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
