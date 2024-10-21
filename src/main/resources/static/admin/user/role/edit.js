layui.use(['form', 'laydate', 'laydate'], function () {
    let form = layui.form;
    form.render();
    let laydate = layui.laydate;

    laydate.render({
        elem: '#startTime',
        type: 'datetime',
        fullPanel: true
    });

    laydate.render({
        elem: '#endTime',
        type: 'datetime',
        fullPanel: true
    });

    /* 提交 */
    form.on('submit(editUserRoleInfo)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/user/role/info/' + data.field.id,
            data: data.field,
            callback: function (res) {
                parent.reloadUserRoleTableData(null, {});
                layer.alert(res.msg,
                    {title: "系统提示", icon: $.msg.icon(LAYER_STATUS.SUCCESS)},
                    function () {
                        $.flyer.close();
                    });
            }
        })
    });

});
