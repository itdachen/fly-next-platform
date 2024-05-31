layui.use(['form'], function () {
    let form = layui.form;
    form.render();

    let thatLevelTitle = '总部';
    // 监听单选框
    form.on('radio(thatLevelRadio)', function (data) {
        thatLevelTitle = data.elem.title; // 得到被选中的单选框的显示标题
    });

    /* 提交 */
    form.on('submit(saveClazzInfo)', function (data) {
        let fieldData = data.field;
        fieldData.thatLevelTitle = thatLevelTitle;
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/clazz/info',
            data: fieldData
        })
    });

});