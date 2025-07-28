/*
 ++++++++++++++++++++++++++++++++++
 + 新增 导入导出测试
 + @author 王大宸
 + @date 2025-07-28 16:55:09
 ++++++++++++++++++++++++++++++++++
 */
layui.use(['form'], function () {
    let form = layui.form;
    form.render();
                        


    /* 提交 */
    form.on('submit(saveOplogPoiTest)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/oplog/poi/test' ,
            data: data.field,
            reload:  parent.reloadOplogPoiTestTableData
        })
    });

});
