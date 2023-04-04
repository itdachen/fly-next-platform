layui.use(['form', 'upload'], function () {
    let form = layui.form;
    form.render();
          let upload = layui.upload;
                                          

            $.oss.imageUpload(upload, {
                id: 'avatarUploadImage',
                tipsBox: 'avatarUploadTips',
                imageSrc: 'avatarImgSrc',
                fieldName: 'avatar',
                uri: $('#avatar').val()
            })

    /* 提交 */
    form.on('submit(editUserInfo)', function (data) {
        $.form.submit({
            url: '/admin/user/info/' + data.field.id,
            data: data.field
        })
    });

});
