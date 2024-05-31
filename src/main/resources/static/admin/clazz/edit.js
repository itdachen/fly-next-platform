layui.use(['form'], function () {
    let form = layui.form;
    form.render();

    // 监听单选框
    form.on('radio(thatLevelRadio)', function (data) {
        let thatLevelTitle = data.elem.title; // 得到被选中的单选框的显示标题
        $('#thatLevelTitle').val(thatLevelTitle)
    });

    /* 提交 */
    form.on('submit(editClazzInfo)', function (data) {
        let fieldData = data.field;
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/clazz/info/' + data.field.id,
            data: fieldData
        })
    });

});
