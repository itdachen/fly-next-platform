/**
 * 角色权限
 */
layui.use('form', function () {
    form = layui.form;

    let roleId = $("#roleId").val();
    $.zTree.initTree({
        url: "/admin/role/menu/zTree/" + roleId,
        check: true,
        showIcon: false,
    })
    
    form.on('submit(sub)', function (data) {
        let menuIds = getCheckedTreeNodes();
        let roleId = $("#roleId").val();
        let subData = data.field;
        subData.menuId = menuIds;
        subData.roleId = roleId;
        $.http.post({
            url: "/admin/role/menu",
            data: data.field,
            callback: function (res) {
                $.msg.okMsg(res.msg);
            }
        });
        return false;
    });

});

function getCheckedTreeNodes() {
    let treeObj = $.fn.zTree.getZTreeObj("tree");
    let nodes = treeObj.getCheckedNodes(true);
    let roleCodes = [];
    for (let i = 0; i < nodes.length; i++) {
        roleCodes.push(nodes[i].id)
    }
    return roleCodes.join(",");
}