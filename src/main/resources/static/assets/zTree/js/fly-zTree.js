const zTreeId = 'tree';

/**
 * zTree 方法封装
 */
(function ($) {
    $.extend({
        zTree: {
            init: function (options) {
                if ($.string.isEmpty(options.url)) {
                    $.msg.msgWarning("请填写获取 zTree 数据的地址");
                }
                if ($.string.isEmpty(options.treeId)) {
                    options.treeId = "tree";
                }
                if ($.string.isEmpty(options.initCallback)) {
                    if ($.string.isEmpty(options.setting)) {
                        options.setting = $.zTree.setting(options);
                    }
                    options.initCallback = function (res) {
                        let data = res.data;
                        $.fn.zTree.init($("#tree"), options.setting, data);
                        let treeObj = $.fn.zTree.getZTreeObj(options.treeId);
                        console.log(treeObj)
                        // let node = sitFolderTree.getNodeByParam("id", "root", null);
                        // sitFolderTree.expandNode(node, true, false, true);
                    }
                }
                /* 获取数据 */
                $.http.get(options.url, options.initCallback);
            },
            /* 获取选中的节点 */
            getCheckedNodes: function (treeId) {
                let treeObj = $.fn.zTree.getZTreeObj(treeId);
                return treeObj.getCheckedNodes(true);
            },
            /* 获取选中的id,返回字符串 */
            getCheckedId: function (treeId) {
                let nodes = $.zTree.getCheckedNodes(treeId);
                if (undefined === nodes || null === nodes
                    || '' === nodes || 0 === nodes.length) {
                    return "";
                }
                let roleCodes = [];
                for (let i = 0; i < nodes.length; i++) {
                    roleCodes[i] = nodes[i].id;
                }
                return roleCodes.join(",");
            },
            /* zTree 设置 */
            setting: function (options) {
                if ($.string.isEmpty(options.check)) {
                    options.check = false;
                }
                if ($.string.isEmpty(options.idKey)) {
                    options.idKey = "id";
                }
                if ($.string.isEmpty(options.pIdKey)) {
                    options.pIdKey = "parentId";
                }
                if ($.string.isEmpty(options.rootPId)) {
                    options.rootPId = "";
                }
                if ($.string.isEmpty(options.showIcon)) {
                    options.showIcon = true;
                }
                if ($.string.isEmpty(options.dblClickExpand)) {
                    options.dblClickExpand = false;
                }
                if ($.string.isEmpty(options.showLine)) {
                    options.showLine = true;
                }
                if ($.string.isEmpty(options.selectedMulti)) {
                    options.selectedMulti = false;
                }
                if ($.string.isEmpty(options.enableSimpleData)) {
                    options.enableSimpleData = true;
                }
                if ($.string.isEmpty(options.callback)) {
                    options.callback = function () {
                        $.msg.msgWarning("请添加回调函数(callback)属性");
                        return false;
                    };
                }
                return {
                    check: {
                        enable: options.check
                    },
                    view: {
                        dblClickExpand: options.dblClickExpand,
                        showLine: options.showLine,
                        selectedMulti: options.selectedMulti,
                        showIcon: options.showIcon
                    },
                    data: {
                        simpleData: {
                            enable: options.enableSimpleData,
                            idKey: options.idKey,
                            pIdKey: options.pIdKey,
                            rootPId: options.rootPId
                        }
                    },
                    callback: {
                        onClick: options.callback
                    }
                };
            },
        },
    })
})(jQuery);