layui.use(['form'], function () {
    let form = layui.form;
    form.render();


    /* 提交 */
    form.on('submit(editMenuInfo)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/menu/info/' + data.field.id,
            data: data.field,
            callback: function (res) {
                parent.initTree();
                parent.reloadTableData();
                layer.alert(res.msg,
                    {title: "系统提示", icon: $.msg.icon(LAYER_STATUS.SUCCESS)},
                    function () {
                        $.model.close();
                    });
            }
        })
    });

});


/**
 * 修改上级菜单目录
 */
function editParentTitle() {
    let appId = $('#appId').val();
    $.flyer.open("修改上级目录", HTTP_BIZ_URI + "/admin/menu/info/" + appId + "/edit/parent/title", "300", "400");
}

/**
 * 给上级菜单ID赋值
 * @param parentId
 * @param title
 */
function setParentMenuValue(parentId, title) {
    console.log('parentId: ' + parentId + ", title: " + title)
    $("#parentId").val(parentId);
    $("#parentTitle").val(title);
}

