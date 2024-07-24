layui.use(['form'], function () {
    let form = layui.form;
    form.render();
              


    /* 提交 */
    form.on('submit(savePlatformInfo)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/platform/info' ,
            data: data.field,
            reload: parent.reloadPlatformInfoTableData
        })
    });

});
