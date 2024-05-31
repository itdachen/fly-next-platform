/**
 * 修改上级菜单目录
 */
var parentMenu = null;
$(function () {
    let appId = $('#appId').val();
    /* 初始化菜单树 */
    $.zTree.initTree({
        url: HTTP_BIZ_URI + "/admin/menu/info/catalog/" + appId + "/zTree",
        callback: function (event, treeId, treeNode) {
            parentMenu = treeNode;
        }
    })

    /* 关闭弹窗 */
    $("#subEditParent").click(function () {
        if (null != parentMenu) {
            parent.setParentMenuValue(parentMenu.id, parentMenu.name)
        }
        $.model.close();
    });
});