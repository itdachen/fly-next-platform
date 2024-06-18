layui.use(['form'], function () {
    let form = layui.form;
    form.render();


    /* 提交 */
    form.on('submit(editDeptInfo)', function (data) {
        let formData = data.field;
        let provTitle = $("#provId option:selected").text();
        let cityTitle = $("#cityId option:selected").text();
        let countyTitle = $("#countyId option:selected").text();

        formData.provTitle = provTitle;
        formData.cityTitle = cityTitle;
        formData.countyTitle = countyTitle;

        $.form.submit({
            url: HTTP_BIZ_URI + '/admin/dept/info/' + data.field.id,
            data: data.field,
            callback: function (res) {
                parent.initDeptTree(null);
                parent.reloadDeptTableData(null, {});
                layer.alert(res.msg,
                    {title: "系统提示", icon: $.msg.icon(LAYER_STATUS.SUCCESS)},
                    function () {
                        $.flyer.close();
                    });
            }
        })
    });




    let oldProvId = $('#oldProvId').val();
    let oldCountyId = $('#oldCountyId').val();
    let oldCityId = $('#oldCityId').val();

    /* 回显省份信息 */
    $.form.selectHttpOption(form, {
        id: 'provId',
        url: HTTP_BIZ_URI + '/admin/area/prov/list',
        showDefault: true,
        placeholder: '请选择省/自治区/直辖市',
        keyId: 'id',
        keyName: 'name',
        value: oldProvId
    })

    /* 回显市州信息 */
    $.form.selectHttpOption(form, {
        id: 'cityId',
        url: HTTP_BIZ_URI + '/admin/area/city/' + oldProvId + '/list',
        showDefault: true,
        placeholder: '请选择市/州',
        keyId: 'id',
        keyName: 'name',
        value: oldCityId
    })

    /* 回显区县 */
    $.form.selectHttpOption(form, {
        id: 'countyId',
        url: HTTP_BIZ_URI + '/admin/area/county/' + oldCityId + '/list',
        showDefault: true,
        placeholder: '请选择区/县',
        keyId: 'id',
        keyName: 'name',
        value: oldCountyId
    })


    form.on('select(provIdFilter)', function (data) {
        let provId = data.value; // 获取选中的省份ID
        if ($.string.isEmpty(provId)) {
            $.msg.msgWarning('请选择省/自治区/直辖市');
            return;
        }
        $.form.selectHttpOption(form, {
            id: 'cityId',
            url: HTTP_BIZ_URI + '/admin/area/city/' + provId + '/list',
            showDefault: true,
            placeholder: '请选择市/州',
            keyId: 'id',
            keyName: 'name',
            value: oldCityId
        })


        // form.render('select'); // 更新城市下拉框的UI
    });

    // 监听城市下拉框
    form.on('select(cityIdFilter)', function (data) {
        // 根据选择的城市进行操作
        let cityId = data.value;
        if ($.string.isEmpty(cityId)) {
            $.msg.msgWarning('请选择市/州');
            return;
        }

        $.form.selectHttpOption(form, {
            id: 'countyId',
            url: HTTP_BIZ_URI + '/admin/area/county/' + cityId + '/list',
            showDefault: true,
            placeholder: '请选择区/县',
            keyId: 'id',
            keyName: 'name',
            value: oldCountyId
        })

    });


});
