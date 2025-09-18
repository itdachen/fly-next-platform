/*
 ++++++++++++++++++++++++++++++++++
 + 新增 部门职能管理
 + @author 王大宸
 + @date 2025-09-18 23:03:17
 ++++++++++++++++++++++++++++++++++
 */
layui.use(['form'], function () {
    let form = layui.form;
    form.render();
          


    /* 提交 */
    form.on('submit(saveDeptFunc)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/dept/func' ,
            data: data.field,
            reload:  parent.reloadDeptFuncTableData
        })
    });

});
