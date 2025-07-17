/*
 ++++++++++++++++++++++++++++++++++
 + 新增 消息附件
 + @author 王大宸
 + @date 2025-07-11 22:52:18
 ++++++++++++++++++++++++++++++++++
 */
layui.use(['form', 'laydate', 'laydate', 'laydate', 'laydate'], function () {
    let form = layui.form;
    form.render();
                                            let laydate = layui.laydate;
              let laydate = layui.laydate;
                let laydate = layui.laydate;
              let laydate = layui.laydate;
          

        laydate.render({
            elem: '#downloadFirstTime'
        });

        laydate.render({
            elem: '#downloadLastTime'
        });

        laydate.render({
            elem: '#readTime'
        });

        laydate.render({
            elem: '#removeTime'
        });


    /* 提交 */
    form.on('submit(saveMsgFile)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/msg/file' ,
            data: data.field,
            reload:  parent.reloadMsgFileTableData
        })
    });

});
