/**
 * 查询数据字段
 */
var dictList = [];
const DICT_PATH = HTTP_BIZ_URI + '/tools/table/info/dict';
function initDict() {
    $.ajax({
        url: DICT_PATH,
        async: false,
        success: function (res) {
            if (200 === res.status) {
                dictList = res.data;
            } else {
                layer.alert('获取数据字典失败', {title: "系统提示", icon: 2});
            }
        }
    })
}




/**
 * 表格数据选中处理
 * @param id     数据id
 * @param value  是否选中状态
 * @param field  字段名称
 */
function columnFilter(id, value, field) {
    for (let i = 0; i < columns.length; i++) {
        if (columns[i].id !== id) {
            continue;
        }
        if (value) {
            columns[i][field] = '1'
        } else {
            columns[i][field] = '0'
        }
        break;
    }
}


/**
 * 所属菜单
 */
function parentMenu() {
    layer.open({
        type: 2,
        title: '选择所属菜单',
        maxmin: false,
        shadeClose: false,
        area: ['350px', '500px'],
        content: HTTP_BIZ_URI +  '/tools/table/info/dirt/menu'
    });
}

/**
 * 给菜单id赋值
 * @param menuId
 * @param menuName
 */
function setMenuValue(menuId, menuName) {
    $("#menuId").val(menuId);
    $("#menuName").val(menuName);
}


/**
 * 下拉赋值
 * @param id      数据id
 * @param value   数据下拉选中的值
 * @param field   字段名称
 * @returns {string}
 */
function selectHtmlTemplate(id, value, field) {
    let list = [];
    let keyId = 'value';
    let keyName = 'label';
    if ('htmlType' === field) {
        list = htmlType();
    }
    if ('queryType' === field) {
        list = queryType();
    }
    if ('dictType' === field) {
        list = dictList;
        keyId = 'id';
        keyName = 'name';
    }
    if ('javaType' === field) {
        list = javaType();
    }
    let nameField = id + '_' + field;
    let html = '<select id="' + nameField + '" name="' + nameField + '" class="layui-border" lay-ignore>';
    for (let i = 0; i < list.length; i++) {
        if (list[i][keyId] === value) {
            html += '<option value="' + list[i][keyId] + '" selected>' + list[i][keyName] + '</option>';
            continue;
        }
        html += '<option value="' + list[i][keyId] + '">' + list[i][keyName] + '</option>';
    }
    html += '</select>';
    return html;
}

/**
 * 选中的值赋值
 * @param obj    对象
 */
function assignmentField(obj) {
    let value;
    let id;
    let field;
    for (let i in obj) {
        value = obj[i];
        if (i.indexOf('queryType') !== -1 || i.indexOf('javaType') !== -1
            || i.indexOf('htmlType') !== -1 || i.indexOf('dictType') !== -1) {
            id = i.split('_')[0];
            field = i.split('_')[1]
            for (let j = 0; j < columns.length; j++) {
                if (columns[j].id === id) {
                    columns[j][field] = value;
                }
            }
        }
    }
}

/**
 * 数据库查询类型
 * @returns {[{label: string, value: string}, {label: string, value: string}, {label: string, value: string}, {label: string, value: string}, {label: string, value: string}, null, null, null]}
 */
const queryType = () => {
    return [{
        value: 'EQ',
        label: '='
    },
        {
            value: 'NE',
            label: '!='
        },
        {
            value: 'GT',
            label: '>'
        },
        {
            value: 'GTE',
            label: '>='
        },
        {
            value: 'LT',
            label: '<'
        },
        {
            value: 'LTE',
            label: '<='
        },
        {
            value: 'LIKE',
            label: 'LIKE'
        },
        {
            value: 'BETWEEN',
            label: 'BETWEEN'
        }]
}


/**
 * 显示类型
 * @returns {[{label: string, value: string}, {label: string, value: string}, {label: string, value: string}, {label: string, value: string}, {label: string, value: string}, null, null, null, null]}
 */
const htmlType = () => {
    return [
        {
            value: 'input',
            label: '文本框'
        },
        {
            value: 'textarea',
            label: '文本域'
        },
        {
            value: 'select',
            label: '下拉框'
        },
        {
            value: 'radio',
            label: '单选框'
        },
        {
            value: 'checkbox',
            label: '复选框'
        },
        {
            value: 'datetime',
            label: '日期控件'
        },
        {
            value: 'imageUpload',
            label: '图片上传'
        },
        {
            value: 'fileUpload',
            label: '文件上传'
        },
        // {
        //     value: 'editor',
        //     label: '富文本控件'
        // },
    ]
}

/**
 * java 字段类型
 * @returns {[{label: string, value: string}, {label: string, value: string}, {label: string, value: string}, {label: string, value: string}, {label: string, value: string}, null, null, null]}
 */
const javaType = () => {
    return [
        {
            value: 'Long',
            label: 'Long'
        },
        {
            value: 'String',
            label: 'String'
        },
        {
            value: 'Integer',
            label: 'Integer'
        },
        {
            value: 'Double',
            label: 'Double'
        },
        {
            value: 'BigDecimal',
            label: 'BigDecimal'
        },
        {
            value: 'LocalDateTime',
            label: 'LocalDateTime'
        },
        {
            value: 'Boolean',
            label: 'Boolean'
        },
        {
            value: 'Date',
            label: 'Date'
        }
    ]
}