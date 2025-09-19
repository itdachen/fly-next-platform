layui.use(['form'], function () {
    let form = layui.form;
    form.render();

    let thatLevelTitle = '总部';
    let deptFuncTitle = '-';
    let clazzFuncTitle = '-';
    // 监听单选框
    form.on('radio(thatLevelRadio)', function (data) {
        thatLevelTitle = data.elem.title; // 得到被选中的单选框的显示标题
        console.log('thatLevelTitle', thatLevelTitle)
    });

    form.on('select(deptFuncCodeSelect)', function (data) {
        deptFuncTitle = data.elem[data.elem.selectedIndex].text;
        console.log('deptFuncTitle', deptFuncTitle); // 获取选中的文本值
    });

    form.on('select(clazzFuncTitleSelect)', function (data) {
        clazzFuncTitle = data.elem[data.elem.selectedIndex].text;
        console.log('deptFuncTitle', clazzFuncTitle); // 获取选中的文本值
    });


    /* 提交 */
    form.on('submit(saveClazzInfo)', function (data) {
        let fieldData = data.field;
        fieldData.thatLevelTitle = thatLevelTitle;
        fieldData.deptFuncTitle = deptFuncTitle;
        fieldData.clazzFuncTitle = clazzFuncTitle;

        let clazzTitle = thatLevelTitle + '-' + deptFuncTitle + '-' + clazzFuncTitle;
        fieldData.clazzTitle = clazzTitle;

        let clazzCode = '1' + fieldData.thatLevelCode + fieldData.deptFuncCode + fieldData.clazzFuncCode;
        fieldData.clazzCode = clazzCode;

        console.log('saveClazzInfo', fieldData)
        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/clazz/info',
            data: fieldData,
            reload: parent.reloadClazzTableData
        })
    });

});