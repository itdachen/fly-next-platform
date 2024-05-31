/**
 * 人员身份岗位设置
 */
layui.use('form', function () {
    let form = layui.form;
    let roleId = $("#roleId").val();
    $.zTree.initTree({
        url: HTTP_BIZ_URI + "/admin/user/role/info/clazz/" + roleId + '/tree',
        check: true,
        showIcon: false,
    })

    form.on('submit(saveUserRoleInfo)', function (data) {
        let menuIds = getCheckedTreeNodes();
        let roleId = $("#roleId").val();
        let subData = data.field;
        subData.clazzId = menuIds;
        subData.roleId = roleId;
        console.log(subData)

        $.http.post({
            url: "/admin/auth/clazz/role",
            data: subData,
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