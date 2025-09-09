/*
 ++++++++++++++++++++++++++++++++++
 + 编辑 操作日志
 + @author 王大宸
 + @date 2025-09-09 17:52:15
 ++++++++++++++++++++++++++++++++++
 */
layui.use(['form', 'laydate'], function () {
    let form = layui.form;
    form.render();
                                                    let laydate = layui.laydate;
                                      

            laydate.render({
                elem: '#opTime'
            });

    /* 提交 */
    form.on('submit(editOplogInfo)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/oplog/info/' + data.field.id,
            data: data.field,
            reload:  parent.reloadOplogInfoTableData
        })
    });

});
