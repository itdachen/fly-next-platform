/*
 ++++++++++++++++++++++++++++++++++
 + 编辑 岗位职能管理
 + @author 王大宸
 + @date 2025-09-18 22:27:28
 ++++++++++++++++++++++++++++++++++
 */
layui.use(['form'], function () {
    let form = layui.form;
    form.render();
        

    /* 提交 */
    form.on('submit(editClazzFunc)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/clazz/func/' + data.field.id,
            data: data.field,
            reload:  parent.reloadClazzFuncTableData
        })
    });

});
