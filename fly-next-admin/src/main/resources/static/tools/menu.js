/**
 * 角色权限
 */
layui.use('form', function () {

    $.zTree.initTree({
        url: '/tools/table/info/dirt/zTree',
        showIcon: true,
        callback: function (event, treeId, treeNode) {
            parent.setMenuValue(treeNode.id, treeNode.name);
            parent.layer.close(parent.layer.getFrameIndex(window.name));
        }
    })

});