layui.use(['form'], function () {
    let form = layui.form;


    $.http.get({
        url: HTTP_BIZ_URI + '/admin/platform/info/list',
        callback: function (res) {
            let options = {
                id: 'platId',
                data: res.data,
                keyId: 'id',
                keyName: 'title',
                showDefault: true,
                placeholder: '请选择平台'
            };
            $.form.selectOption(form, options);
        }
    });

    form.render();

    /* 提交 */
    form.on('submit(saveAppInfo)', function (data) {
        let platTitle = $("#platId option:selected").text();
        let obj = data.field;
        obj.platTitle = platTitle;
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/app/info',
            data: obj,
            reload: parent.reloadAppTableData
        })
    });

});
