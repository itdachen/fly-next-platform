/**
 *  岗位权限设置
 */
layui.use('form', function () {
    let form = layui.form;
    let clazzCode = $("#clazzCode").val();
    let appId = $("#appId").val();
    $.zTree.initTree({
        url: HTTP_BIZ_URI + '/admin/auth/grant/menu/clazz/' + clazzCode + '/app/' + appId + '/tree',
        check: true,
        showIcon: false,
    })

    form.on('submit(saveClazzMenuInfo)', function (data) {
        let menuIds = getCheckedTreeNodes();
        let clazzCode = $("#clazzCode").val();
        let appId = $("#appId").val();
        let subData = data.field;
        subData.appId = appId;
        subData.clazzCode = clazzCode;
        subData.funcId = menuIds;
        console.log(subData)

        $.http.post({
            url: "/admin/auth/clazz/menu",
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