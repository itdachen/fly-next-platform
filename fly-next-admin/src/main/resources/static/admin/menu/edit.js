layui.use(['form'], function () {
    let form = layui.form;
    form.render();


    /* 提交 */
    form.on('submit(editMenuInfo)', function (data) {
        $.form.submit({
            url: '/admin/menu/info/' + data.field.id,
            data: data.field,
            callback: function (res) {
                layer.alert(res.msg,
                    {title: "系统提示", icon: $.msg.icon(LAYER_STATUS.SUCCESS)},
                    function () {
                        parent.initTree();
                        parent.reloadTableData();
                        $.model.close();
                    });
            }
        })
    });

});
