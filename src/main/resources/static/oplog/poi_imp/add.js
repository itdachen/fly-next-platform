/*
 ++++++++++++++++++++++++++++++++++
 + 新增 导入日志
 + @author 王大宸
 + @date 2025-07-28 15:55:31
 ++++++++++++++++++++++++++++++++++
 */
layui.use(['form', 'laydate'], function () {
    let form = layui.form;
    form.render();


    /* 提交 */
    form.on('submit(saveOplogPoiImp)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/oplog/poi/imp',
            data: data.field,
            reload: parent.reloadOplogPoiImpTableData
        })
    });

});
