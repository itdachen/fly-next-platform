/*
 ++++++++++++++++++++++++++++++++++
 + 新增 页面访问日志
 + @author 王大宸
 + @date 2025-09-09 21:56:31
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
    form.on('submit(saveOplogPageView)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/oplog/page/view' ,
            data: data.field,
            reload:  parent.reloadOplogPageViewTableData
        })
    });

});
