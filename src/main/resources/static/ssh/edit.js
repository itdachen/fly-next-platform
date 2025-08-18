/*
 ++++++++++++++++++++++++++++++++++
 + 编辑 SSH 连接
 + @author 王大宸
 + @date 2025-08-18 22:58:10
 ++++++++++++++++++++++++++++++++++
 */
layui.use(['form'], function () {
    let form = layui.form;
    form.render();
              

    /* 提交 */
    form.on('submit(editSshServerConfig)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/ssh/server/' + data.field.id,
            data: data.field,
            reload:  parent.reloadSshServerConfigTableData
        })
    });

});
