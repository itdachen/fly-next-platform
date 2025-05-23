layui.use(['form', 'laydate', 'laydate'], function () {
    let form = layui.form;
    form.render();
    let laydate = layui.laydate;


    laydate.render({
        elem: '#startTime',
        type: 'datetime',
        fullPanel: true // 2.8+
    });

    laydate.render({
        elem: '#endTime',
        type: 'datetime',
        fullPanel: true // 2.8+
    });


    /* 提交 */
    form.on('submit(saveUserRoleInfo)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/user/role/info',
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

/**
 * 搜索用户信息
 */
function searchUserInfo() {
    let username = $('#username').val();
    if ($.string.isEmpty(username)) {
        $.msg.msgWarning('请输入登录账号！');
        return;
    }
    $.http.get({
        url: HTTP_BIZ_URI + '/admin/user/info/' + username,
        callback: function (res) {
            if (null === res.data) {
                $.msg.msgWarning("人员信息不存在!");
                return;
            }
            let data = res.data;
            $('#nickName').val(data.nickName);
            $('#roleName').val(data.nickName);
            $('#userId').val(data.id);
        }
    })
}
