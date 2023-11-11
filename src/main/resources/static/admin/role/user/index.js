/**
 * 角色权限
 */
layui.use('form', function () {
    let form = layui.form;

    init();

    form.on('submit(sub)', function (data) {
        let menuIds = getCheckedTreeNodes();
        let userId = $("#userId").val();
        $.http.post({
            url: "/admin/role/user",
            data: {
                roleId: menuIds,
                userId: userId,
                clientId: CLIENT_ID
            },
            callback: function (res) {
                $.msg.okMsg(res.msg);
            }
        });
        return false;
    });

});

function init() {
    let setting = $.zTree.setting({
        check: true,
        showIcon: false,
        callback: function (e, treeId, treeNode) {
            zTree.checkNode(treeNode, !treeNode.checked, true);
        }
    })

    let userId = $("#userId").val();
    $.zTree.initTree({
        url: "/admin/role/user/zTree/" + userId,
        initCallback: function (res) {
            zTree = $.fn.zTree.init($("#tree"), setting, res.data);
            sitFolderTree = $.fn.zTree.getZTreeObj("tree");
            sitFolderTree.expandAll(true);
        },
    })
}

function getCheckedTreeNodes() {
    let treeObj = $.fn.zTree.getZTreeObj("tree");
    let nodes = treeObj.getCheckedNodes(true);
    let roleCodes = [];
    for (let i = 0; i < nodes.length; i++) {
        roleCodes.push(nodes[i].id)
    }
    return roleCodes.join(",");
}