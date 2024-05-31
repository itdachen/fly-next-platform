layui.use(['form'], function () {
    let form = layui.form;


    let oldPlatId = $('#oldPlatId').val();
    $.form.selectHttpOption(form, {
        id: 'platId',
        url: HTTP_BIZ_URI + '/admin/platform/info/list',
        keyId: 'id',
        keyName: 'title',
        showDefault: true,
        placeholder: '请选择平台',
        value: oldPlatId
    });

    form.render();

    /* 提交 */
    form.on('submit(editAppInfo)', function (data) {
        let platTitle = $("#platId option:selected").text();
        let obj = data.field;
        obj.platTitle = platTitle;
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/app/info/' + data.field.id,
            data: obj
        });
    });

});
