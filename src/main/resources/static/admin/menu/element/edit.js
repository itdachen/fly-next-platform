layui.use(['form'], function () {
    let form = layui.form;
    form.render();
                                  

    /* 提交 */
    form.on('submit(editElementInfo)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/element/info/' + data.field.id,
            data: data.field,
            callback: function (res) {
                layer.alert(res.msg, {title: "系统提示", icon: $.msg.icon(LAYER_STATUS.SUCCESS)},
                    function () {
                        parent.reloadTableElementData(null, {});
                        $.model.close();
                    });
            }
        })
    });

});
