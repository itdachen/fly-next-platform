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