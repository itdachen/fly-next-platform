/*
 ++++++++++++++++++++++++++++++++++
 + 新增 消息池
 + @author 王大宸
 + @date 2025-07-11 22:52:18
 ++++++++++++++++++++++++++++++++++
 */
layui.use(['form', 'laydate', 'laydate'], function () {
    let form = layui.form;
    form.render();
                                                              let laydate = layui.laydate;
              let laydate = layui.laydate;
          

        laydate.render({
            elem: '#readTime'
        });

        laydate.render({
            elem: '#removeTime'
        });


    /* 提交 */
    form.on('submit(saveMsgPool)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/msg/pool' ,
            data: data.field,
            reload:  parent.reloadMsgPoolTableData
        })
    });

});
