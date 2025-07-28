/*
 ++++++++++++++++++++++++++++++++++
 + 编辑 导入日志
 + @author 王大宸
 + @date 2025-07-28 15:55:31
 ++++++++++++++++++++++++++++++++++
 */
layui.use(['form', 'laydate'], function () {
    let form = layui.form;
    form.render();
                                                                                    let laydate = layui.laydate;
          

            laydate.render({
                elem: '#removeTime'
            });

    /* 提交 */
    form.on('submit(editOplogPoiImp)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/oplog/poi/imp/' + data.field.id,
            data: data.field,
            reload:  parent.reloadOplogPoiImpTableData
        })
    });

});
