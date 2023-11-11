layui.use(['form', 'iconPicker'], function () {
    let form = layui.form;
    form.render();
    let iconPicker = layui.iconPicker;

    iconPicker.render({
        // 选择器，推荐使用input
        elem: '#icon',
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
            $('#icon').val(icon);
        },
        // 渲染成功后的回调
        success: function (d) {
            console.log(d);
        }
    });

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

/**
 * 修改上级菜单目录
 */
function editParent() {
    $.model.open("修改上级目录", "/admin/menu/info/edit/parent", "300", "400");
}

/**
 * 修改上级菜单赋值
 * @param parentId  上级菜单id
 * @param title     上级菜单目录名称
 */
function setParentMenuValue(parentId, title) {
    $("#parentId").val(parentId);
    $("#parentTitle").val(title);
}