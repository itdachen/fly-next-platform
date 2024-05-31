layui.use(['form'], function () {
    let form = layui.form;
    form.render();

    let iconPicker = layui.iconPicker;


    /* 提交 */
    form.on('submit(saveMenuInfo)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/menu/info',
            data: data.field,
            callback: function (res) {
                parent.initTree();
                parent.reloadTableData();
                layer.alert(res.msg,
                    {title: "系统提示", icon: $.msg.icon(LAYER_STATUS.SUCCESS)},
                    function () {
                        $.flyer.close();
                    });
            }
        })
    });

    iconPicker.render({
        // 选择器，推荐使用input
        elem: '#layIcon',
        // 数据类型：fontClass/unicode，推荐使用fontClass
        type: 'fontClass',
        // 是否开启搜索：true/false
        search: true,
        // 是否开启分页
        page: false,
        // 每页显示数量，默认12
        limit: 16,
        // 点击回调
        click: function (data) {
            let icon = data.icon;
            $('#layIcon').val(icon);
        },
        // 渲染成功后的回调
        success: function (d) {
            console.log(d);
        }
    });


});
