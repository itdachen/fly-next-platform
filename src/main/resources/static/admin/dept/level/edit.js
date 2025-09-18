/*
 ++++++++++++++++++++++++++++++++++
 + 编辑 部门等级
 + @author 王大宸
 + @date 2025-09-18 22:02:49
 ++++++++++++++++++++++++++++++++++
 */
layui.use(['form'], function () {
    let form = layui.form;
    form.render();
          

    /* 提交 */
    form.on('submit(editDeptLevel)', function (data) {
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/dept/level/' + data.field.id,
            data: data.field,
            reload:  parent.reloadDeptLevelTableData
        })
    });

});
