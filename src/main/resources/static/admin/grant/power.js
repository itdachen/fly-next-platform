/**
 *  岗位权限设置
 */
layui.use('form', function () {
    let form = layui.form;
    let roleId = $("#roleId").val();
    let appId = $("#appId").val();
    $.zTree.initTree({
        url: HTTP_BIZ_URI + '/admin/auth/grant/menu/' + roleId + '/app/' + appId + '/tree',
        check: true,
        showIcon: false,
    })

    form.on('submit(saveClazzMenuInfo)', function (data) {
        let menuIds = getCheckedTreeNodes();
        let roleId = $("#roleId").val();
        let appId = $("#appId").val();
        let subData = data.field;
        subData.appId = appId;
        subData.roleId = roleId;
        subData.meniId = menuIds;
        console.log(subData)

        $.http.post({
            url: "/admin/auth/grant/menu",
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