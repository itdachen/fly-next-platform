/**
 * 通用js
 */
$(function () {
    /* 关闭弹窗 */
    $("#buttonClose").click(function () {
        $.model.close();
    });
});

/**
 * Description: 常用js方法封装
 * Created by 王大宸 on 2021-11-21 16:32
 * Created with IntelliJ IDEA.
 */
(function ($) {
    $.extend({

        /**
         * http 请求统一封装
         */
        http: {
            /**
             * 添加上下文路径
             * @param uri 请求路径
             * @returns {*|string|string}
             */
            verifyURL: function (uri) {
                if ($.string.contain(uri, 'http://') || $.string.contain(uri, 'https://')) {
                    return uri;
                }
                if ($.string.isNotEmpty(HTTP_BIZ_URI) && uri.substring(0, HTTP_BIZ_URI.length) !== HTTP_BIZ_URI) {
                    return HTTP_BIZ_URI + uri;
                }
                return uri;
            },

            /**
             * GET 请求
             * @param options
             */
            get: function (options) {
                $.ajax($.http.request(options));
            },

            /**
             * post 请求
             * @param options
             */
            post: function (options) {
                options.type = HTTP_METHOD.POST;
                $.ajax($.http.request(options));
            },

            /**
             * put 请求
             * @param options
             */
            put: function (options) {
                options.type = HTTP_METHOD.PUT;
                $.ajax($.http.request(options));
            },

            /**
             * delete 请求
             * @param options
             */
            delete: function (options) {
                options.type = HTTP_METHOD.DELETE;
                $.ajax($.http.request(options));
            },

            defaultOptions: {
                type: 'GET',
                contentType: 'application/json',
                datatype: 'json',
                url: '/error/404',
                cache: false,
                callback: function (res) {
                    console.warn('请设置 callback 回调函数属性')
                    console.log(res)
                },
                errCallback: function (err) {
                    $.http.errResponse(err)
                },
                error: function (err) {
                    console.warn('数据请求失败!!!');
                    console.warn(err);
                    $.msg.ajaxError();
                },
                xhrFields: {
                    withCredentials: true
                }
            },

            /**
             * 请求拦截器
             * @param option
             * @returns {*}
             */
            request: function (option) {
                let options = $.extend({}, $.http.defaultOptions, option);
                options.url = $.http.verifyURL(options.url);
                if ($.string.isEmpty(options.success)) {
                    options.success = function (res) {
                        $.http.response(res, options.callback, options.errCallback);
                    }
                }
                options.data = JSON.stringify(option.data);
                return options;
            },

            /**
             * 响应拦截器
             * @param res           请求返回结果
             * @param callback      后台操作成功回调函数
             * @param errCallback   后台操作失败回调函数
             */
            response: function (res, callback, errCallback) {
                if (res.success) {
                    callback(res);
                    return
                }
                errCallback(res);
            },

            /**
             * 后台才做失败统一拦截处理
             * @param err
             * @returns {*}
             */
            errResponse: function (err) {
                // 参数校验失败
                if (STATUS_CODE.PARAMS_VALID === err.status) {
                    $.msg.msgValid(err.msg, err.data);
                    return;
                }
                // 参数校验失败,自定义返回信息
                if (STATUS_CODE.PARAMS_VALID_MSG === err.status) {
                    $.msg.msgValidCustom(err.msg);
                    return;
                }
                // 警告/提示
                if (STATUS_CODE.WARNING === err.status) {
                    $.msg.msgWarning(err.msg);
                    return;
                }
                // 错误
                if (STATUS_CODE.ERROR === err.status) {
                    $.msg.errMsg(err.msg);
                    return;
                }
                // 登录查询没有用户
                if (STATUS_CODE.NO_LOGIN_USER_INFO === err.status) {
                    $.msg.msgDataError(err.msg, err.data);
                    return;
                }
                // 登录查询账户被锁
                if (STATUS_CODE.LOCKED_ACCOUNT === err.status) {
                    $.msg.msgDataError(err.msg, err.data);
                    return;
                }
                // 密码错误
                if (STATUS_CODE.USER_PASSWORD_NOT_MATCH === err.status) {
                    $.msg.errMsg(err.msg);
                    return;
                }
                // 没有session,跳转到登录页面
                if (STATUS_CODE.CLIENT_TOKEN_EXCEPTION === err.status) {
                    top.document.location.href = err.data;
                } else {
                    console.warn(err);
                    return $.msg.error("程序发生了一个错误！");
                }
            }

        },

        msg: {
            // 显示图标
            icon: function (type) {
                let icon = "";
                if (LAYER_STATUS.WARNING === type) {
                    icon = 0;
                } else if (LAYER_STATUS.SUCCESS === type) {
                    icon = 1;
                } else if (LAYER_STATUS.ERROR === type) {
                    icon = 2;
                } else if (LAYER_STATUS.CONFIRM === type) {
                    icon = 3;
                } else if (LAYER_STATUS.LOCKUP === type) {
                    icon = 4;
                } else if (LAYER_STATUS.UNHAPPY === type) {
                    icon = 5;
                } else if (LAYER_STATUS.HAPPY === type) {
                    icon = 6;
                }
                return icon;
            }, // ajax 请求连接错误
            ajaxError: function () {
                $.model.alert("服务器连接失败，请联系技术人员！", LAYER_STATUS.ERROR);
            }, // 操作成功,关闭弹窗
            okMsg: function (msg) {
                layer.alert(msg, {title: "系统提示", icon: $.msg.icon(LAYER_STATUS.SUCCESS)}, function () {
                    $.model.close();
                });
            }, customMsg: function (msg = '操作成功', options, callback) {
                if ($.string.isEmpty(options.title)) {
                    options.title = '系统提示'
                }
                if ($.string.isEmpty(options.title)) {
                    options.icon = $.msg.icon(LAYER_STATUS.SUCCESS)
                }
                if ($.string.isEmpty(callback)) {
                    callback = function (res) {
                        console.warn('消息回调[callback]不能为空...')
                    }
                }
                layer.msg(msg, options, callback())
            }, // 错误消息
            errMsg: function (content) {
                $.model.alert(content, LAYER_STATUS.ERROR);
            }, msgDataWarning: function (msg, data) {
                $.model.alert('<span style="color: #ff000c"> ' + $.string.replace(msg, "!", "：") + ' </span>' + '<br>' + data, LAYER_STATUS.WARNING);
            }, msgDataError: function (msg, data) {
                $.model.alert('<span style="color: #ff000c"> ' + $.string.replace(msg, "!", "：") + ' </span>' + '<br>' + data, LAYER_STATUS.ERROR);
            }, // 成功消息
            msgSuccess: function (content) {
                layer.msg(content, {
                    icon: 1, time: 1500
                });
            }, // 警告消息
            msgWarning: function (content) {
                $.model.alert(content, LAYER_STATUS.WARNING);
            }, // 请求参数错误,例如:  msg: 请求参数错误;data: 用户名不能为空
            msgValid: function (msg, data) {
                $.model.alert('<span style="color: #ff000c">' + $.string.replace(msg, "！", "：") + '</span>' + '<br>' + data, LAYER_STATUS.WARNING);
            }, // 请求参数错误,自定义消息提示,例如: msg: 用户名不能为空
            msgValidCustom: function (msg) {
                $.model.alert('<span style="color: #ff000c">参数校验错误：</span>' + '<br>' + msg, LAYER_STATUS.WARNING);
            },
        },

        form: {
            /**
             * 表单提交,如果数据有id,则是更新,没有id,则是修改数据
             * @param options
             */
            submit: function (options) {
                $.form.submitCommon(options);
                if ($.string.isEmpty(options.data.id)) {
                    $.http.post(options)
                } else {
                    $.http.put(options);
                }
            },

            /**
             * 表单新增数据提交
             * 必传传入属性: url/data
             * 选传参数属性: callback(回调函数)
             * @param options
             */
            save: function (options) {
                $.form.submitCommon(options);
                $.http.post(options)
            },

            /**
             * 表单修改数据提交
             * 必传传入属性: url/data
             * 选传参数属性: callback(回调函数)
             * @param options
             */
            update: function (options) {
                $.form.submitCommon(options);
                $.http.put(options);
            },

            /**
             * form 表单提交基础设置
             * @param options
             */
            submitCommon: function (options) {
                if ($.string.isEmpty(options.url)) {
                    console.warn('数据请求地址[url]不能为空')
                    return
                }
                if ($.string.isEmpty(options.data)) {
                    console.warn('传输数据 [data] 属性不能为空')
                    return
                }
                if ($.string.isEmpty(options.reload)) {
                    options.reload = parent.reloadTableData;
                }
                if ($.string.isEmpty(options.callback)) {
                    options.callback = function (res) {
                        options.reload();
                        $.msg.okMsg(res.msg);
                    }
                }
                if ($.string.isEmpty(options.errCallback)) {
                    options.errCallback = function (err) {
                        $.http.errResponse(err)
                    }
                }
            },

            /**
             * http 请求复选框
             * @param form
             * @param options
             */
            checkBoxHttpOption: function (form, options) {
                /* 下拉数据请求路径 */
                if ($.string.isEmpty(options.url)) {
                    console.warn('请传入数据请求地址 [url]');
                    return;
                }
                $.http.get({
                    url: options.url, callback: function (res) {
                        options.data = res.data;
                        $.form.checkBoxOption(form, options);
                    }
                })
            },

            /**
             * 复选框渲染
             * @param form
             * @param options
             */
            checkBoxOption: function (form, options) {
                if ($.string.isEmpty(options.id)) {
                    console.warn('div id 不能为空');
                    return;
                }
                let d = $.form.defineProps;
                d.done = function (o) {
                    let arr = o.value.split(',');
                    let disabledValue = o.disabledValue.split(',');
                    let filter = o.filter;
                    if (o.hasFilter && $.string.isEmpty(filter)) {
                        filter = o.name + 'Filter'
                    }
                    let data = o.data;
                    let html;
                    for (let i = 0; i < data.length; i++) {
                        html = '<input type="checkbox" name="' + o.name + '_' + data[i][o.keyId] + '" value="' + data[i][o.keyId] + '" title="' + data[i][o.keyName] + '"';
                        /* 原始复选框 */
                        if (o.primary) {
                            html += ' lay-skin="primary"';
                        }
                        /* 禁用, 多个 value 之间用逗号拼接 */
                        if (disabledValue.indexOf(data[i][o.keyId]) !== -1) {
                            html += ' disabled=""'
                        }
                        /* 数据回显 */
                        if (arr.indexOf(data[i][o.keyId]) !== -1) {
                            html += 'checked=""'
                        }
                        /* 如果打开选中监听,设置 filter, 如果没有设置 filter ,提供默认 filter, 并警告 */
                        if (o.hasFilter) {
                            html += ' lay-filter="' + filter + '"'
                        }
                        html += '>';
                        $('#' + o.id).append(html);
                    }
                    form.render();
                }

                let p = $.extend({}, d, options);
                p.done(p);

            },

            /**
             * 请求数据获取下拉
             * @param form
             * @param options
             */
            selectHttpOption: function (form, options) {
                /* 下拉数据请求路径 */
                if ($.string.isEmpty(options.url)) {
                    console.warn('请传入数据请求地址 [url]');
                    return;
                }
                $.http.get({
                    url: options.url, callback: function (res) {
                        options.data = res.data;
                        $.form.selectOption(form, options);
                    }
                })
            },

            /**
             * 下拉框
             * @param form
             * @param options
             */
            selectOption: function (form, options) {
                let d = $.form.defineProps;
                d.done = function (o) {
                    /* 清空之前的数据 */
                    $("#" + o.id + " option").remove();
                    /* 默认显示 */
                    if (o.showDefault) {
                        $("#" + o.id + "").append("<option value=''>" + o.placeholder + "</option>");
                    }
                    let html = '';
                    let arr = o.value.split(',');
                    let disabledValue = o.disabledValue.split(',');
                    let data = o.data;
                    for (let i = 0; i < data.length; i++) {
                        html += '<option value="' + data[i][o.keyId] + '"';
                        /* 禁用, 多个 value 之间用逗号拼接 */
                        if (disabledValue.indexOf(data[i][o.keyId]) !== -1) {
                            html += ' disabled=""'
                        }
                        /* 数据回显 */
                        if (arr.indexOf(data[i][o.keyId]) !== -1) {
                            html += ' selected=""'
                        }
                        html += '>' + data[i][o.keyName] + '</option>'
                    }
                    $('#' + o.id).append(html);
                    form.render();
                }
                let p = $.extend({}, d, options);
                p.done(p)
            },

            /**
             * 获取复选框选中的值
             * @param name  复选框 name
             * @returns {string}  返回字符串,多个之间用逗号隔开
             */
            selectGetValue: function (name = '') {
                if ($.string.isEmpty(name)) {
                    console.warn('获取值的 name 不能为空')
                    return '';
                }
                let value = [];
                $('input[name=' + name + ']:checked').each(function () {
                    value.push($(this).val());
                });
                return value.join(",");
            },

            /**
             * 清除下拉数据
             * @param form
             * @param id    select下拉id
             * @param placeholder 清除之后的提示
             */
            selectClean: function (form, {id = '', placeholder = '请选择'}) {
                if ($.string.isEmpty(id)) {
                    console.warn('请传入 select id')
                    id = 'name'
                }
                $("#" + id + " option").remove();
                $("#" + id).append("<option value=''>" + placeholder + "</option>");
                form.render();
            },

            /**
             * 单选获取数据展示单选
             * @param form
             * @param options
             */
            radioHttpOption: function (form, options) {
                /* 下拉数据请求路径 */
                if ($.string.isEmpty(options.url)) {
                    console.warn('请传入数据请求地址 [url]');
                    return;
                }
                $.http.get({
                    url: options.url, callback: function (res) {
                        options.data = res.data;
                        $.form.radioOption(form, options)
                    }
                })
            },

            /**
             * 单选框
             * @param form
             * @param options
             */
            radioOption: function (form, options) {
                let d = $.form.defineProps;
                d.done = function (p) {
                    let html = ''
                    let disabledValue = p.disabledValue.split(',');
                    let data = p.data;
                    let value = p.value;
                    for (let i = 0; i < data.length; i++) {
                        html += '<input type="radio" ';
                        html += ' id=' + p.name + '_' + data[i][p.keyId] + ' name="' + p.name + '" value="' + data[i][p.keyId] + '" title="' + data[i][p.keyName] + '"';
                        if ((data[i][p.keyId]) === value) {
                            html += ' checked=""'
                        }
                        if (disabledValue.indexOf(data[i][p.keyId]) !== -1) {
                            html += ' disabled=""';
                        }
                        if (p.hasFilter) {
                            html += ' lay-filter="' + p.filter + '"';
                        }
                        html += '>';
                    }
                    $("#" + p.id + "").append(html);
                    form.render();
                }

                let p = $.extend({}, d, options);
                p.done(p);
            },


            /**
             * 清除下拉数据
             * @param form
             * @param id    select下拉id
             * @param placeholder 清除之后的提示
             */
            selectRemove: function (form, {id = '', placeholder = '请选择'}) {
                if ($.string.isEmpty(id)) {
                    console.warn('请传入 select id')
                    return;
                }
                $("#" + id + " option").remove();
                $("#" + id + "").append("<option value=''>" + placeholder + "</option>");
                form.render();
            },


            /**
             * form 表单基础设置
             * @param options
             */
            formCommon: function (options) {
                if ($.string.isEmpty(options.id)) {
                    console.warn('请传入节点 id');
                    return;
                }
                /* value 属性 */
                if ($.string.isEmpty(options.keyId)) {
                    options.keyId = 'id';
                }
                /* 显示属性 */
                if ($.string.isEmpty(options.keyName)) {
                    options.keyName = 'name';
                }
                /* 禁用属性 */
                if ($.string.isEmpty(options.disabledId)) {
                    options.disabledId = 'disabledId'
                }
                /* 禁用值 */
                if ($.string.isEmpty(options.disabledValue)) {
                    options.disabledValue = 'disabledValue'
                }
                /* 需要选中的值 */
                if ($.string.isEmpty(options.value)) {
                    options.value = '';
                }
                /* 是否开启选中监听 */
                if ($.string.isEmpty(options.hasFilter)) {
                    options.hasFilter = false;
                }
                /* 如果打开选中监听,设置 filter, 如果没有设置 filter ,提供默认 filter, 并警告 */
                if (options.hasFilter && $.string.isEmpty(options.filter)) {
                    console.warn('请传入监听 filter 属性, 默认 filter 为 [' + options.id + '-filter]');
                    options.filter = options.id + '-filter';
                }
            },

            defineProps: {
                id: 'layDefineForm',
                keyId: 'id',
                keyName: 'name',
                disabledId: 'disabledId',
                disabledValue: 'disabledValue',
                value: '',
                showDefault: true,
                placeholder: '全部',
                hasFilter: false, /* 是否开启选中监听 */
                filter: '',
                name: 'name',
                disabled: false,
                primary: false
            },

        },

        oss: {
            /**
             * 通用文件上传, 默认上传图片
             * @param upload  layui 文件上传
             * @param options 自定义配置
             */
            upload: function (upload, options) {
                $.oss.common(options);
                upload.render(options);
            },

            /**
             * 文件下载
             * @param uri      文件网络地址
             * @param fileName 文件名
             */
            download: function ({uri = '', fileName = ''}) {
                if ($.string.isEmpty(uri)) {
                    console.warn('文件下载[ uri ]参数不能为空')
                    return false;
                }
                location.href = '/oss/download?uri=' + uri + '&filename=' + fileName
            },

            /**
             * 文件上传
             * @param uri      文件网络地址
             * @param fileName 文件名
             * @returns {boolean}
             */
            downloadFile: function (uri = '', fileName = '') {
                if ($.string.isEmpty(uri)) {
                    console.warn('文件下载[ uri ]参数不能为空')
                    return false;
                }
                location.href = '/oss/download?uri=' + uri + '&filename=' + fileName
            },

            /**
             * 上传文件
             * @param upload
             * @param options
             */
            fileUpload: function (upload, options) {
                if ($.string.isEmpty(options.exts)) {
                    options.exts = 'jpg|png|gif|bmp|jpeg|zip|rar|7z|doc|docx|txt|xlsx|xls|ppt|pptx';
                }
                if ($.string.isEmpty(options.fileUri)) {
                    // 存放路径字段id
                    options.fileUri = 'fileUri';
                }
                if ($.string.isEmpty(options.fileName)) {
                    // 存放文件名称id
                    options.fileName = 'fileName';
                }
                if ($.string.isEmpty(options.callback)) {
                    options.callback = function (res) {
                        $('#' + options.fileUri).val(res.data.url);
                        $("#" + options.fileName).val(res.data.name);
                    }
                }
                $.oss.common(options);
                upload.render(options);
            },

            /**
             *  图片上传
             * @param upload  layui 文件上传
             * @param options 自定义配置
             */
            imageUpload: function (upload, options) {
                /* 如果这个属性存在, 则显示 */
                if ($.string.isNotEmpty(options.uri)) {
                    // 没有上传图片之前展示默认提示的div id
                    $('#' + options.tipsBox).css('display', 'none');
                    // 图标展示的 img
                    $('#' + options.imageSrc).attr('src', options.uri).css('display', 'block');
                    // 表单存放字段 name 的id
                    $("#" + options.fieldName).val(options.uri);
                }
                if ($.string.isEmpty(options.callback)) {
                    options.callback = function (res) {
                        // 没有上传图片之前展示默认提示的div id
                        $('#' + options.tipsBox).css('display', 'none');
                        // 图标展示的 img
                        $('#' + options.imageSrc).attr('src', res.data.url).css('display', 'block');
                        // 表单存放字段 name 的id
                        $("#" + options.fieldName).val(res.data.url);
                    }
                }
                $.oss.common(options);


                //      let d = $.oss.defineProps;

                upload.render(options);
            },

            /**
             * layui.upload 通用配置(如果部分配置,没有自定义配置,则使用默认的通用配置)
             * @param options 自定义配置
             */

            defineProps: {
                id: 'upload',
                elem: '#upload',
                url: uploadURL,
                checkMD5: false,
                accept: 'file',
                exts: 'jpg|png|gif|bmp|jpeg',
                xhrFields: {
                    withCredentials: true
                },
                callback: function (res) {
                    console.log('文件上传成功', res)
                },
                auto: false, // 关闭自动上传的配置：auto: false，这一步非常关键
                choose: function (obj, o) {
                    uploadLayer = layer.load(); // 上传loading
                    $(".layui-layer-shade").css('background', '#000000')
                    $(".layui-layer-shade").css('opacity', '0.2')

                    /* 文件 md5 校验
                     *  参考: https://blog.csdn.net/wuyu7448/article/details/121533985
                     *  */
                    // this.config.elem.next()[0].value = '';
                    obj.preview(function (index, file, result) {
                        if (o.checkMD5) {
                            /* 校验文件 MD5 */
                            $.oss.checkFileMd5(index, file, obj, o.callback);
                        } else {
                            obj.upload(index, file);
                        }
                    })
                },
                done: function (res, o) {
                    layer.close(uploadLayer);
                    let code = res.status;
                    if (STATUS_CODE.SUCCESS === code) {
                        o.callback(res);
                    } else if (STATUS_CODE.ERROR === code) {
                        $.msg.msgWarning($.oss.msg(o.type) + res.msg);
                    } else {
                        $.msg.errMsg("文件上传失败!");
                    }
                },
                error: function () {
                    layer.msg("文件上传服务连接失败,请联系技术人员!", {
                        icon: $.model.icon(LAYER_STATUS.ERROR), time: 1500
                    });
                }

            },


            common: function (options) {
                if ($.string.isEmpty(options.id)) {
                    options.id = "upload";
                }
                if ($.string.isEmpty(options.elem)) {
                    options.elem = '#' + options.id
                }
                if ($.string.isEmpty(options.url)) {
                    options.url = uploadURL;
                }
                /* 是否检查文件 MD5 (针对大文件,或者文件秒传) */
                if ($.string.isEmpty(options.checkMD5)) {
                    options.checkMD5 = false;
                }
                if ($.string.isEmpty(options.accept)) {
                    // file video audio images
                    // 目前后端接收为 file
                    options.accept = 'file';
                }
                if ($.string.isEmpty(options.exts)) {
                    // 默认 jpg|png|gif|bmp|jpeg
                    // 压缩文件格式 zip|rar|7z
                    // 文档 doc|docx|txt|xlsx|xls|ppt|pptx
                    options.exts = 'jpg|png|gif|bmp|jpeg';
                }
                if ($.string.isEmpty(options.xhrFields)) {
                    options.xhrFields = {
                        withCredentials: true
                    }
                }
                if ($.string.isEmpty(options.callback)) {
                    options.callback = function (res) {
                        console.log('文件上传成功', res)
                    }
                }
                /* 关闭自动上传的配置：auto: false，这一步非常关键 */
                if ($.string.isEmpty(options.auto)) {
                    options.auto = false;
                }
                if ($.string.isEmpty(options.choose)) {
                    options.choose = function (obj) {
                        uploadLayer = layer.load(); // 上传loading
                        $(".layui-layer-shade").css('background', '#000000')
                        $(".layui-layer-shade").css('opacity', '0.2')

                        /* 文件 md5 校验
                         *  参考: https://blog.csdn.net/wuyu7448/article/details/121533985
                         *  */
                        // this.config.elem.next()[0].value = '';
                        obj.preview(function (index, file, result) {
                            if (options.checkMD5) {
                                /* 校验文件 MD5 */
                                $.oss.checkFileMd5(index, file, obj, options.callback);
                            } else {
                                obj.upload(index, file);
                            }
                        })
                    }
                }
                if ($.string.isEmpty(options.done)) {
                    options.done = function (res) {
                        layer.close(uploadLayer);
                        let code = res.status;
                        if (STATUS_CODE.SUCCESS === code) {
                            options.callback(res);
                        } else if (STATUS_CODE.ERROR === code) {
                            $.msg.msgWarning($.oss.msg(options.type) + res.msg);
                        } else {
                            $.msg.errMsg("文件上传失败!");
                        }
                    }
                }
                if ($.string.isEmpty(options.error)) {
                    options.error = function () {
                        layer.msg("文件上传服务连接失败,请联系技术人员!", {
                            icon: $.model.icon(LAYER_STATUS.ERROR), time: 1500
                        });
                    }
                }
            },

            /**
             * 校验文件 md5, 仅在文件上传 options.choose 中调用
             * @param index  文件序号
             * @param file   需要上传的文件
             * @param obj    文件上传
             * @param callback  回调函数
             */
            checkFileMd5(index, file, obj, callback) {
                if (running) {
                    return;
                }
                let blobSlice = File.prototype.slice || File.prototype.mozSlice || File.prototype.webkitSlice;
                let fileReader = new FileReader();
                let currentChunk = 0;
                let chunkSize = 2097152;
                let chunks = Math.ceil(file.size / chunkSize);
                let spark = new SparkMD5.ArrayBuffer();

                running = true;
                loadNext();

                fileReader.onload = function (e) {
                    spark.append(e.target.result);                 // append array buffer
                    currentChunk += 1;
                    if (currentChunk < chunks) {
                        loadNext();
                    } else {
                        let md5Hex = spark.end();
                        $.ajax({
                            url: uploadCheckMD5URL + md5Hex, // async: false,
                            success: function (res) {
                                if (null != res.data) {
                                    running = false;
                                    layer.close(uploadLayer);
                                    callback(res, file.name)
                                } else {
                                    running = false;
                                    obj.upload(index, file)
                                }
                            },
                        })
                    }
                };

                fileReader.onerror = function () {
                    running = false;
                };

                function loadNext() {
                    let start = currentChunk * chunkSize,
                        end = start + chunkSize >= file.size ? file.size : start + chunkSize;
                    fileReader.readAsArrayBuffer(blobSlice.call(file, start, end));
                }
            }
        },

        model: {
            // 弹出提示
            alert: function (content, type) {
                layer.alert(content, {
                    icon: $.msg.icon(type), title: "系统提示", btn: ['确认'], btnclass: ['btn btn-primary'],
                });
            }, // 关闭窗体
            close: function () {
                parent.layer.close(parent.layer.getFrameIndex(window.name));
            }, // 关闭全部窗体
            closeAll: function () {
                layer.closeAll();
            }, // 单张图片弹出
            openImg(title, url, width, height) {
                parent.layer.open({
                    type: 1,
                    title: title,
                    shadeClose: false,
                    area: [width + 'px', height + 'px'],
                    content: '<img style="width:100%;height:100%"  src="' + $.http.verifyURL(url) + '" />',
                    btn: ['关闭'],
                    anim: 5,
                    btn2: function () {
                        layer.closeAll();
                    }
                });
            }, // 查看，弹出全屏
            openFullSee(title, url) {
                let width = ($(window).width() - 50);
                let height = ($(window).height() - 50);
                layer.open({
                    type: 2,
                    area: [width + 'px', height + 'px'],
                    fix: false,
                    maxmin: true,
                    shade: 0.3,
                    title: title,
                    content: $.http.verifyURL(url),
                    shadeClose: true,
                    btn: ['关闭'],
                    yes: function (index) {
                        return true;
                    }
                });
            }, // 弹出全屏
            openFull(title, url) {
                let width = ($(window).width() - 50);
                let height = ($(window).height() - 50);
                layer.open({
                    type: 2,
                    area: [width + 'px', height + 'px'],
                    fix: false,
                    maxmin: true,
                    shade: 0.3,
                    title: title,
                    content: $.http.verifyURL(url),
                    shadeClose: true
                });
            }, openIframe: function (options) {
                if ($.string.isEmpty(options.title)) {
                    options.title = '内容';
                }
                if ($.string.isEmpty(options.content)) {
                    options.title = '请输入内容地址或者内容信息 【content】';
                }
                if ($.string.isEmpty(options.area)) {
                    options.area = ['60%', '80%'];
                }
                layer.open({
                    type: 2,
                    title: options.title,
                    content: $.http.verifyURL(options.content),
                    area: options.area,
                    fix: false,
                    maxmin: false,
                    shade: 0.3,
                    shadeClose: false,
                    success: function (layero, index) {
                        layer.iframeAuto(index);
                    },
                });
            }, openIframeSee: function (options) {
                if ($.string.isEmpty(options.title)) {
                    options.title = '查看';
                }
                if ($.string.isEmpty(options.content)) {
                    options.title = '请输入内容地址或者内容信息 【content】';
                }
                if ($.string.isEmpty(options.area)) {
                    options.area = ['60%', '80%'];
                }
                layer.open({
                    type: 2,
                    title: options.title,
                    content: $.http.verifyURL(options.content),
                    area: options.area,
                    fix: false,
                    maxmin: false,
                    shade: 0.3,
                    shadeClose: false,
                    btn: ['关闭'],
                    success: function (layero, index) {
                        layer.iframeAuto(index);
                    },
                });
            }, // 弹出层指定宽度
            open: function (title, url, width, height) {
                //如果是移动端，就使用自适应大小弹窗
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    width = 'auto';
                    height = 'auto';
                }
                if ($.string.isEmpty(title)) {
                    title = false;
                }
                if ($.string.isEmpty(url)) {
                    url = "/404.html";
                }
                if ($.string.isEmpty(width)) {
                    width = 800;
                }
                if ($.string.isEmpty(height)) {
                    height = ($(window).height() - 50);
                }
                layer.open({
                    type: 2,
                    area: [width + 'px', height + 'px'],
                    fix: false,
                    maxmin: false,
                    shade: 0.3,
                    title: title,
                    content: $.http.verifyURL(url), // 弹层外区域关闭
                    shadeClose: false
                });
            }, see: function (title, url, width, height) {
                //如果是移动端，就使用自适应大小弹窗
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    width = 'auto';
                    height = 'auto';
                }
                if ($.string.isEmpty(title)) {
                    title = false;
                }
                if ($.string.isEmpty(url)) {
                    url = "/404.html";
                }
                if ($.string.isEmpty(width)) {
                    width = 800;
                }
                if ($.string.isEmpty(height)) {
                    height = ($(window).height() - 50);
                }
                layer.open({
                    type: 2,
                    content: $.http.verifyURL(url),
                    area: [width + 'px', height + 'px'],
                    fix: false,
                    maxmin: false,
                    shade: 0.3,
                    title: title,
                    btn: ['关闭'],
                    shadeClose: false,
                    cancel: function (index) {
                        return true;
                    }
                });
            }, // 禁用按钮
            disable: function () {
                var doc = window.top == window.parent ? window.document : window.parent.document;
                $("a[class*=layui-layer-btn]", doc).addClass("layer-disabled");
            }, // 启用按钮
            enable: function () {
                var doc = window.top == window.parent ? window.document : window.parent.document;
                $("a[class*=layui-layer-btn]", doc).removeClass("layer-disabled");
            }, // 弹出层
            iframe: function (title, url, width, height) {
                layer.open({
                    type: 2,
                    title: title,
                    maxmin: false,
                    shadeClose: false,
                    area: [width + 'px', height + 'px'],
                    content: $.http.verifyURL(url)
                });
            }, load: function () {
                layer.load(0, {shade: 0.3});
            }
        },

        // uri: {
        //     verifyURL(url) {
        //         if ($.string.isNotEmpty(baseURL) && url.substring(0, baseURL.length) !== baseURL) {
        //             return baseURL + url;
        //         }
        //         return url;
        //     }
        // },


        /* table 统一处理 */
        table: {

            /**
             * 表格初始化
             * @param t  layui.table
             * @param o  表格参数对象
             */
            init: function (t, o) {
                if ($.string.isEmpty(t)) {
                    t = layui.table;
                }
                let d = $.table.defineProps;
                let p = $.extend({}, d, o);
                return t.render(p);
            },

            /**
             * layui table 默认设置
             */
            defineProps: {
                id: 'layTable',
                elem: '#layTable',
                toolbar: '#toolbar',
                layFilter: 'layFilter',
                defaultToolbar: ['filter', 'exports', 'print'],
                headers: {
                    appKey: '2022'
                },
                cellMinWidth: 80,
                skin: 'line', // 设置表格边框风格。可选值：grid(官方默认)、line（行边框风格）、row（列边框风格）、nob（无边框风格）
                even: false,   // 开启隔行背景
                size: 'lg',   // 大尺寸, sm （小尺寸）
                response: {
                    statusName: 'status', //规定数据状态的字段名称，默认：code
                    statusCode: 200 //规定成功的状态码，默认：0
                },
                text: {
                    none: '暂无相关数据' //默认：无数据。
                    // none: '/static/common/images/none_data.svg'
                },
                parseData: function (res) { //res 即为原始返回的数据
                    return {
                        "status": res.status, //解析接口状态
                        "msg": res.message, //解析提示文本
                        "count": res.data.total, //解析数据长度
                        "data": res.data.rows //解析数据列表
                    };
                },
                page: {
                    theme: '#1E9FFF',
                    groups: 5,
                    limits: [10, 15, 30, 50, 100, 500, 10000],
                    layout: ['prev', 'page', 'next', 'limit', 'skip', 'refresh', 'count'],
                    prev: '上一页',
                    next: '下一页'
                },
                done: function (res, curr, count) {
                    $.table.textTips();
                },
            },

            /**
             * 默认通用分页
             * @returns {{layout: string[], next: string, prev: string, groups: number, theme: string, limits: number[]}}
             */
            pagination: {
                theme: '#1E9FFF',
                groups: 5,
                limits: [10, 15, 30, 50, 100, 500, 10000],
                layout: ['prev', 'page', 'next', 'skip', 'refresh', 'limit', 'count'],
                prev: '上一页',
                next: '下一页'
            },

            /**
             * 刷新数据
             * @param t
             * @param o
             */
            reloadData: function (t, o) {
                if ($.string.isEmpty(t)) {
                    t = layui.table;
                }
                let d = $.table.defineProps;
                let p = $.extend({}, d, o);
                p.where = queryWhere();
                p.page.curr = 1;
                t.reloadData(p.id, p);
            },

            /**
             * 刷新数据
             * @param t layui table
             * @param i 表格id
             */
            reloadTableData: function (t, i) {
                if ($.string.isEmpty(t)) {
                    t = layui.table;
                }
                if ($.string.isEmpty(i)) {
                    i = $.table.defineProps.id;
                }
                let page = $.table.defineProps.page;
                page.curr = 1;
                t.reloadData(i, {
                    where: queryWhere(), page: page
                });
            },

            remove: function (url, callback, errCallback) {
                $.http.delete({
                    url: url, callback: function (res) {
                        callback(res)
                    }, errCallback: function (err) {
                        errCallback(err);
                    }
                })
            },

            /**
             * 表格删除数据
             * @param options
             */
            delete: function (options) {
                if ($.string.isEmpty(options)) {
                    console.warn('删除参数错误,应传入{title:"",callback:""} 等参数')
                }
                /* 消息是否自定义 */
                // options.custom ? options.custom : options.custom = false
                //  if ($.string.isEmpty(options.custom)) {
                //      options.custom = false;
                //  }
                let msg = '确定删除【' + options.title + '】信息吗？';
                if ($.string.isEmpty(options.title)) {
                    msg = '确定删除该数据信息吗？'
                }
                if (options.custom) {
                    msg = options.title
                }
                if ($.string.isEmpty(options.reloadTable)) {
                    options.reloadTable = reloadTableData;
                }
                /* 删除数据之后的回调 */
                if ($.string.isEmpty(options.callback)) {
                    options.callback = function (res) {
                        options.reloadTable();
                        layer.msg(res.msg, {icon: 1, time: 1500});
                    }
                }
                if ($.string.isEmpty(options.errCallback)) {
                    options.errCallback = function (err) {
                        $.http.errResponse(err)
                    }
                }
                layer.confirm('<div style="color: #ff000c">' + msg + '</div>', {
                    icon: 3, title: '系统提示！'
                }, function () {
                    $.http.delete(options)
                });
            },

            /**
             * 表格文字鼠标漂浮显示
             */
            textTips: function () {
                let x = 10, y = 20;
                let newTitle = '';
                $('td').each(function (index, element) {
                    if ($(element).text() !== '' && $(element).text() != null) {
                        $(element).attr('title', $(element).text()).addClass('tdTitle');
                    }
                });
                $(".layui-table-col-special").removeClass("tdTitle").attr("title", "");
                $('td.tdTitle').mouseover(function (e) {
                    newTitle = this.title;
                    this.title = '';
                    $('body').append('<div id="tooltip">' + newTitle + '</div>');
                    $('#tooltip').css({
                        'left': (e.pageX + x + 'px'), 'top': (e.pageY + y + 'px'),
                    }).show();
                }).mouseout(function () {
                    this.title = newTitle;
                    $('#tooltip').remove();
                }).mousemove(function (e) {
                    $('#tooltip').css({
                        'left': (e.pageX + x + 'px'), 'top': (e.pageY + y + 'px')
                    }).show();
                })
            },

        },

        /**
         * 字符串处理
         */
        string: {
            /**
             * 去掉字符串空格
             * @param str
             * @returns {*}
             */
            trim: function (str) {
                return str.replace(/(^\s*)|(\s*$)/g, '');
            },

            /**
             * 判断字符串是否为空
             * @param value
             * @returns {boolean}
             */
            isEmpty: function (value) {
                return (undefined === value || null === value || "" === value || "null" === value);
            },

            /**
             * 判断一个字符串是否为非空串
             * @param value
             * @returns {boolean}
             */
            isNotEmpty: function (value) {
                return !$.string.isEmpty(value);
            },

            /**
             * 判断字符串 str 里面是否包含目标字符串 value
             * @param str
             * @param value
             * @returns {boolean} true/包含;false/不包含
             */
            contain: function (str, value) {
                return str.indexOf(value) !== -1
            },

            /**
             * 字符串替换
             * @param str
             * @param oldChar
             * @param newChar
             * @returns {*}
             */
            replace: function (str, oldChar, newChar) {
                return str.replace(oldChar, newChar)
            }
        },

        /** zTree */
        zTree: {
            /** 初始化 zTree */
            initTree: function (options) {
                if ($.string.isEmpty(options.url)) {
                    $.msg.msgWarning("请填写获取 zTree 数据的地址");
                }
                if ($.string.isEmpty(options.id)) {
                    options.id = 'tree';
                }
                if ($.string.isEmpty(options.initCallback)) {
                    if ($.string.isEmpty(options.setting)) {
                        options.setting = $.zTree.setting(options);
                    }
                    options.initCallback = function (res) {
                        let data = res.data;
                        $.fn.zTree.init($("#" + options.id), options.setting, data);
                    }
                }
                /* 获取数据 */
                $.http.get({
                    url: options.url, callback: options.initCallback
                });
            },

            /** 获取选中的节点 */
            getCheckedNodes: function (treeId = 'tree') {
                let treeObj = $.fn.zTree.getZTreeObj(treeId);
                return treeObj.getCheckedNodes(true);
            },

            /** 获取选中的id,返回字符串 */
            getCheckedId: function (treeId = 'tree') {
                let nodeIdArr = $.zTree.getCheckedArr(treeId);
                if (undefined === nodeIdArr || null === nodeIdArr || '' === nodeIdArr || 0 === nodeIdArr.length) {
                    return "";
                }
                return nodeIdArr.join(",");
            },

            getCheckedArr: function (treeId = 'tree') {
                let nodes = $.zTree.getCheckedNodes(treeId);
                if (undefined === nodes || null === nodes || '' === nodes || 0 === nodes.length) {
                    return [];
                }
                let roleCodes = [];
                for (let i = 0; i < nodes.length; i++) {
                    roleCodes.push(nodes[i].id);
                }
                return roleCodes;
            },

            /**
             * 获取树信息
             * @param treeId
             * @returns {null}
             */
            getZTreeObj: function (treeId = 'tree') {
                return $.fn.zTree.getZTreeObj(treeId);
            },

            /** zTree 设置 */
            setting: function (options) {
                let d = {
                    id: "tree",
                    idKey: 'id',
                    pIdKey: 'parentId',
                    treeId: "tree",
                    rootPId: '',
                    showIcon: true,
                    dblClickExpand: false,
                    showLine: true,
                    selectedMulti: false,
                    enableSimpleData: true,
                    check: false,
                    callback: function () {
                        //  $.msg.msgWarning("请添加回调函数(callback)属性");
                        console.warn('请添加回调函数(callback)属性')
                        return false;
                    }
                }
                let p = $.extend({}, d, options);
                return {
                    check: {
                        enable: p.check
                    }, view: {
                        dblClickExpand: p.dblClickExpand,
                        showLine: p.showLine,
                        selectedMulti: p.selectedMulti,
                        showIcon: p.showIcon
                    }, data: {
                        simpleData: {
                            enable: p.enableSimpleData, idKey: p.idKey, pIdKey: p.pIdKey, rootPId: p.rootPId
                        }
                    }, callback: {
                        onClick: p.callback
                    }
                };
            },
        },

    });
})(jQuery);

/* 返回上一页 */
function goBackPreviousPage() {
    window.history.go(-1);
}

/**
 * 获取浏览器比例
 * @returns {number}
 */
function getBrowserZoomScale() {
    let ratio = 0;
    let screen = window.screen;
    let ua = navigator.userAgent.toLowerCase();
    if (window.devicePixelRatio !== undefined) {
        ratio = window.devicePixelRatio;
    } else if (~ua.indexOf("msie")) {
        if (screen.deviceXDPI && screen.logicalXDPI) {
            ratio = screen.deviceXDPI / screen.logicalXDPI;
        }
    } else if (
        window.outerWidth !== undefined &&
        window.innerWidth !== undefined
    ) {
        ratio = window.outerWidth / window.innerWidth;
    }
    if (ratio) {
        ratio = Math.round(ratio * 100);
    }
    return ratio;
}

/**
 * 获取浏览器信息
 * 浏览器名称, 版本号
 * @returns {{name: string, version: string}}
 */
function browserInfo() {
    let agent = navigator.userAgent.toLowerCase();

    let Browser = "", Bversion = "";

    //IE
    if (agent.indexOf("msie") > 0) {
        let regStr_ie = /msie [\d.]+;/gi;
        Browser = "IE";
        Bversion = "" + agent.match(regStr_ie)
    }
    //firefox
    else if (agent.indexOf("firefox") > 0) {
        let regStr_ff = /firefox\/[\d.]+/gi;
        Browser = "firefox";
        Bversion = "" + agent.match(regStr_ff);
    }
    //Chrome
    else if (agent.indexOf("chrome") > 0) {
        let regStr_chrome = /chrome\/[\d.]+/gi;
        Browser = "chrome";
        Bversion = "" + agent.match(regStr_chrome);
    }
    //Safari
    else if (agent.indexOf("safari") > 0 && agent.indexOf("chrome") < 0) {
        let regStr_saf = /version\/[\d.]+/gi;
        Browser = "safari";
        Bversion = "" + agent.match(regStr_saf);
    }
    //Opera
    else if (agent.indexOf("opera") >= 0) {
        let regStr_opera = /version\/[\d.]+/gi;
        Browser = "opera";
        Bversion = "" + agent.match(regStr_opera);
    } else {
        let browser = navigator.appName;
        if ('Netscape' === browser) {
            let version = agent.split(";");
            let trim_Version = version[7].replace(/[ ]/g, "");
            let rvStr = trim_Version.match(/[\d\.]/g).toString();
            Bversion = rvStr.replace(/[,]/g, "");
            Browser = "IE"
        }
    }

    let verinNum = (Bversion + "").replace(/[^0-9.]/ig, "");

    return {
        name: Browser,
        version: verinNum
    }
}


/**
 *  name layuiRowspan
 * @param fieldName  要合并列的field属性值
 * @param index 要合并列的索引值 从1开始(如果要合并第一列，则index = 1;)
 * @desc 此方法适用于合并列冻结的单元格
 */
function layuiRowspan(fieldName, index) {
    // 左侧列为冻结的情况
    var tbodyNode = document.getElementsByClassName("layui-table-fixed-l")[index - 1];
    var child = tbodyNode.getElementsByTagName("td");
    var childFilterArr = [];
    // 获取data-field属性为fieldName的td
    for (var i = 0; i < child.length; i++) {
        if (child[i].getAttribute("data-field") == fieldName) {
            childFilterArr.push(child[i]);
        }
    }
    // 获取td的个数和种类
    var childFilterTextObj = {};
    for (var i = 0; i < childFilterArr.length; i++) {
        var childText = childFilterArr[i].textContent;
        if (childFilterTextObj[childText] == undefined) {
            childFilterTextObj[childText] = 1;
        } else {
            var num = childFilterTextObj[childText];
            childFilterTextObj[childText] = num * 1 + 1;
        }
    }
    // 给获取到的td设置合并单元格属性
    for (var key in childFilterTextObj) {
        var tdNum = childFilterTextObj[key];
        var canRowspan = true;
        for (var i = 0; i < childFilterArr.length; i++) {
            if (childFilterArr[i].getAttribute("data-content") == key) {
                if (canRowspan) {
                    childFilterArr[i].setAttribute("rowspan", tdNum);
                    canRowspan = false;
                } else {
                    childFilterArr[i].style.display = "none";
                }
            }
        }
    }
}

/**
 * name layui 合并 tbody 中单元格的方法
 * @param fieldName  要合并列的field属性值
 * @param index 表格的索引值 从1开始
 * @desc 此方式适用于没有列冻结的单元格合并
 */
function alarmTableRowSpan(fieldName, index) {
    var fixedNode = document.getElementsByClassName("layui-table-body")[index - 1];
    if (!fixedNode) {
        return false;
    }
    var child = fixedNode.getElementsByTagName("td");
    var childFilterArr = [];
    // 获取data-field属性为fieldName的td
    for (var i = 0; i < child.length; i++) {
        if (child[i].getAttribute("data-field") == fieldName) {
            childFilterArr.push(child[i]);
        }
    }
    // 获取td的个数和种类
    var childFilterTextObj = {};
    for (var i = 0; i < childFilterArr.length; i++) {
        var childText = childFilterArr[i].textContent;
        if (childFilterTextObj[childText] == undefined) {
            childFilterTextObj[childText] = 1;
        } else {
            var num = childFilterTextObj[childText];
            childFilterTextObj[childText] = num * 1 + 1;
        }
    }
    // 给获取到的td设置合并单元格属性
    for (var key in childFilterTextObj) {
        var tdNum = childFilterTextObj[key];
        var canRowSpan = true;
        for (var i = 0; i < childFilterArr.length; i++) {
            if (childFilterArr[i].textContent == key) {
                if (canRowSpan) {
                    childFilterArr[i].setAttribute("rowspan", tdNum);
                    canRowSpan = false;
                } else {
                    childFilterArr[i].style.display = "none";
                }
            }
        }
    }
}