layui.use(['form'], function () {
    let form = layui.form;
    form.render();

    form.on('select(methodFilter)', function (obj) {
        if ('POST' === obj.value) {
            $("#button").attr("checked", true);
            $('#title').val('新增')
        }
        if ('GET' === obj.value) {
            $("#uri").attr("checked", true);
            $('#title').val('查询')
        }
        if ('PUT' === obj.value) {
            $("#button").attr("checked", true);
            $('#title').val('编辑')
        }
        if ('DELETE' === obj.value) {
            $("#button").attr("checked", true);
            $('#title').val('删除')
        }
        form.render();
    })

    /* 提交 */
    form.on('submit(saveElementInfo)', function (data) {
        $.form.submit({
            url: '/admin/element/info',
            data: data.field,
            callback: function (res) {
                layer.alert(res.msg, {title: "系统提示", icon: $.msg.icon(LAYER_STATUS.SUCCESS)},
                    function () {
                        parent.reloadElementTableData();
                        $.model.close();
                    });
            }
        })
    });

});
