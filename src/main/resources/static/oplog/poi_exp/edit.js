/*
 ++++++++++++++++++++++++++++++++++
 + 编辑 导出日志
 + @author 王大宸
 + @date 2025-07-23 23:06:08
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
    form.on('submit(editOplogPoiExp)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/oplog/poi/exp/' + data.field.id,
            data: data.field,
            reload:  parent.reloadOplogPoiExpTableData
        })
    });

});
