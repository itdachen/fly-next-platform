(function ($) {
    var h, timerC = 60, opt;
    var j = function (a) {
        a = $.extend(require.defaults, a || {});
        opt = a;
        return (new require())._init(a)
    };

    function require(f) {
        var g = {
            phone: /^1(3\d|5[0-35-9]|8[025-9]|47)\d{8}$/,
            company: /^[\u4E00-\u9FA5a-zA-Z][\u4E00-\u9FA5a-zA-Z0-9\s-,-.]*$/,
            uname: /^[\u4E00-\u9FA5a-zA-Z][\u4E00-\u9FA5a-zA-Z0-9_]*$/,
            zh: /^[\u4e00-\u9fa5]+$/,
            card: /^((1[1-5])|(2[1-3])|(3[1-7])|(4[1-6])|(5[0-4])|(6[1-5])|71|(8[12])|91)\d{4}(((((19|20)((\d{2}(0[13-9]|1[012])(0[1-9]|[12]\d|30))|(\d{2}(0[13578]|1[02])31)|(\d{2}02(0[1-9]|1\d|2[0-8]))|(([13579][26]|[2468][048]|0[48])0229)))|20000229)\d{3}(\d|X|x))|(((\d{2}(0[13-9]|1[012])(0[1-9]|[12]\d|30))|(\d{2}(0[13578]|1[02])31)|(\d{2}02(0[1-9]|1\d|2[0-8]))|(([13579][26]|[2468][048]|0[48])0229))\d{3}))$/,
            int: /^[0-9]*$/,
            s: ''
        };
        this.rules = {
            isNonEmpty: function (a, b) {
                b = b || " ";
                if (!a.length) return b
            }, minLength: function (a, b, c) {
                c = c || " ";
                if (a.length < b) return c
            }, maxLength: function (a, b, c) {
                c = c || " ";
                if (a.length > b) return c
            }, isRepeat: function (a, b, c) {
                c = c || " ";
                if (a !== $("#" + b).val()) return c
            }, between: function (a, b, c) {
                c = c || " ";
                var d = parseInt(b.split('-')[0]);
                var e = parseInt(b.split('-')[1]);
                if (a.length < d || a.length > e) return c
            }, level: function (a, b, c) {
                c = c || " ";
                var r = j.pwdStrong(a);
                if (b > 4) b = 3;
                if (r < b) return c
            }, isPhone: function (a, b) {
                b = b || " ";
                if (!g.phone.test(a)) return b
            }, isCompany: function (a, b) {
                b = b || " ";
                if (!g.company.test(a)) return b
            }, isInt: function (a, b) {
                b = b || " ";
                if (!g.int.test(a)) return b
            }, isUname: function (a, b) {
                b = b || " ";
                if (!g.uname.test(a)) return b
            }, isZh: function (a, b) {
                b = b || " ";
                if (!g.zh.test(a)) return b
            }, isCard: function (a, b) {
                b = b || " ";
                if (!g.card.test(a)) return b
            }, isChecked: function (c, d, e) {
                d = d || " ";
                var a = $(e).find('input:checked').length, b = $(e).find('.on').length;
                if (!a && !b) return d
            }
        }
    };require.prototype = {
        _init: function (b) {
            this.config = b;
            this.getInputs = $('#' + b.formId).find('.required:visible');
            var c = false;
            var d = this;
            if (b.code) {

                $("#verifyYz").click(function () {
                    if ($('#mobile').val().length) {
                        $('.msg').hide()
                        $("#time_box").text("60s后可重发");
                        d._sendVerify()
                    } else {
                        $('.msg').show()
                    }

                })
            }
            $('body').on({
                blur: function (a) {
                    d.formValidator($(this));
                    if (b.phone && $(this).attr("id") === "phone") d._change($(this));
                    b.onBlur ? b.onBlur($(this)) : ''
                }, focus: function (a) {
                    b.onFocus ? b.onFocus($(this)) : $(this).parent().find("label.focus").not(".valid").removeClass("hide").siblings(".valid").addClass("hide") && $(this).parent().find(".blank").addClass("hide") && $(this).parent().find(".close").addClass("hide")
                }, keyup: function (a) {
                    if (b.phone && $(this).attr("id") === "phone") d._change($(this))
                }, change: function (a) {
                    b.onChange ? b.onChange($(this)) : ''
                }
            }, "#" + b.formId + " .required:visible");
            $('body').on("click", ".close", function () {
                var p = $(this).parent(), input = p.find("input");
                input.val("").focus()
            })
        }, formValidator: function (a) {
            var b = a.attr('data-valid');
            if (b === undefined) return false;
            var c = b.split('||');
            var d = a.attr('data-error');
            if (d === undefined) d = "";
            var e = d.split("||");
            var f = [];
            for (var i = 0; i < c.length; i++) {
                f.push({
                    strategy: c[i], errorMsg: e[i]
                })
            }
            ;
            return this._add(a, f)
        }, _add: function (a, b) {
            var d = this;
            for (var i = 0, rule; rule = b[i++];) {
                var e = rule.strategy.split(':');
                var f = rule.errorMsg;
                var g = e.shift();
                e.unshift(a.val());
                e.push(f);
                e.push(a);
                var c = d.rules[g].apply(a, e);
                if (c) {
                    opt.resultTips ? opt.resultTips(a, false, c) : j._resultTips(a, false, c);
                    return false
                }
            }
            opt.successTip ? (opt.resultTips ? opt.resultTips(a, true) : j._resultTips(a, true)) : j._clearTips(a);
            return true
        }, _sendVerify: function () {
            var a = this;
            $("#verifyYz").text("发送验证码").hide();
            $("#time_box").text("10 s后可重发").show();
            if (timerC === 0) {
                clearTimeout(h);
                timerC = 60;
                var b = /^1([^01269])\d{9}$/;
                if (!b.test($("#phone").val())) {
                    $("#time_box").text("发送验证码")
                } else {
                    $("#verifyYz").show();
                    $("#time_box").hide()
                }
                return
            }
            $("#time_box").text(timerC + " s后可重发");
            timerC--;
            h = setTimeout(function () {
                a._sendVerify()
            }, 1000)
        }, _change: function (a) {
            var b = this;
            if (a.val().length != 11) {
                $("#verifyYz").hide();
                $("#time_box").show();
                if (timerC === 60) $("#time_box").text("发送验证码");
                $("#verifyNo").val("");
                this.config.clearTips ? this.config.clearTips($("#verifyNo")) : j._clearTips($("#verifyNo"));
                return
            }
            var c = /^1([^01269])\d{9}$/;
            if (!c.test(a.val())) return false;
            if (timerC === 60) {
                $("#verifyYz").show();
                $("#time_box").hide()
            } else {
                $("#verifyYz").hide();
                $("#time_box").show()
            }
        }
    };
    j._click = function (c) {
        c = c || opt.formId;
        var d = $("#" + c).find('.required:visible'), self = this, result = true, t = new require(), r = [];
        $.each(d, function (a, b) {
            result = t.formValidator($(b));
            if (result) r.push(result)
        });
        if (d.length !== r.length) result = false;
        return result
    };
    j._clearTips = function (a) {
        a.parent().find(".blank").addClass("hide");
        a.parent().find(".valid").addClass("hide");
        a.removeClass("v_error")
    };
    j._resultTips = function (a, b, c) {
        a.parent().find("label.focus").not(".valid").addClass("hide").siblings(".focus").removeClass("hide");
        a.parent().find(".close").addClass("hide");
        a.removeClass("v_error");
        c = c || "";
        if (c.length > 21) c = "<span>" + c + "</span>";
        var o = a.parent().find("label.valid");
        if (!b) {
            o.addClass("error");
            a.addClass("v_error");
            if ($.trim(a.val()).length > 0) a.parent().find(".close").removeClass("hide")
        } else {
            a.parent().find(".blank").removeClass("hide")
        }
        o.text("").append(c)
    };
    j.textChineseLength = function (a) {
        var b = /[\u4E00-\u9FA5]|[\u3001-\u3002]|[\uFF1A-\uFF1F]|[\u300A-\u300F]|[\u3010-\u3015]|[\u2013-\u201D]|[\uFF01-\uFF0E]|[\u3008-\u3009]|[\u2026]|[\uffe5]/g;
        if (b.test(a)) return a.match(b).length; else return 0
    };
    j.pwdStrong = function (a) {
        var b = 0;
        if (a.match(/[a-z]/g)) {
            b++
        }
        if (a.match(/[A-Z]/g)) {
            b++
        }
        if (a.match(/[0-9]/g)) {
            b++
        }
        if (a.match(/(.[^a-z0-9A-Z])/g)) {
            b++
        }
        if (b > 4) {
            b = 4
        }
        if (b === 0) return false;
        return b
    };
    require.defaults = {
        formId: 'verifyCheck',
        onBlur: null,
        onFocus: null,
        onChange: null,
        successTip: true,
        resultTips: null,
        clearTips: null,
        code: true,
        phone: false
    };
    window.verifyCheck = $.verifyCheck = j
})(jQuery);
(function ($) {
    var f;
    var g = function () {
        return (new require())._init()
    };

    function require(a) {
    };require.prototype = {
        _init: function () {
            var b = this;
            $('body').on({
                click: function (a) {
                    b._click($(this))
                }
            }, ".showpwd:visible")
        }, _click: function (a) {
            var c = a.attr('data-eye');
            if (c === undefined) return false;
            var d = $("#" + c), cls = !d.attr("class") ? "" : d.attr("class"), value = !d.val() ? "" : d.val(),
                type = d.attr("type") === "password" ? "text" : "password", b = d.parent().find("b.placeTextB"),
                isB = b.length === 0 ? false : true;
            var s = d.attr("name") ? " name='" + d.attr("name") + "'" : "";
            s += d.attr("data-valid") ? " data-valid='" + d.attr("data-valid") + "'" : "";
            s += d.attr("data-error") ? " data-error='" + d.attr("data-error") + "'" : "";
            s += d.attr("placeholder") ? " placeholder='" + d.attr("placeholder") + "'" : "";
            var e = '<input readonly type="' + type + '" class="' + cls + '" value="' + value + '" id="' + c + '"' + s + ' />';
            if (type === "text") {
                if (isB) b.hide();
                d.parent().find(".icon-close.close").addClass("hide");
                d.removeAttr("id").hide();
                d.after(e);
                a.addClass("hidepwd")
            } else {
                d.prev("input").attr("id", c).val(value).show();
                if (isB && $.trim(value) === "") {
                    d.prev("input").hide();
                    b.show()
                }
                d.remove();
                a.removeClass("hidepwd")
            }
            ;$('body').on("click", "#" + c, function () {
                $(this).parent().find(".hidepwd").click();
                if (isB && $.trim($(this).val()) === "") {
                    d.show();
                    b.hide()
                }
                d.focus()
            })
        }
    };
    require.defaults = {};
    window.togglePwd = $.togglePwd = g
})(jQuery);
(function ($) {
    var b, timerC, opt;
    var d = function (a) {
        a = $.extend(require.defaults, a || {});
        opt = a;
        d._clear();
        return (new require())._init()
    };

    function require(a) {
    };require.prototype = {
        _init: function () {
            timerC = opt.maxTime;
            this._sendVerify()
        }, _sendVerify: function () {
            var a = this;
            if (timerC === 0) {
                d._clear();
                opt.after();
                timerC = opt.maxTime;
                return
            }
            timerC--;
            opt.ing(timerC);
            b = setTimeout(function () {
                a._sendVerify()
            }, 1000)
        }
    };
    d._clear = function () {
        clearTimeout(b)
    };
    require.defaults = {
        maxTime: 60, minTime: 0, ing: function (c) {
        }, after: function () {
        }
    };
    window.countdown = $.countdown = d
})(jQuery);
$(function () {
    togglePwd();
    verifyCheck();
    $('body').on("keyup", "#password", function () {
        var t = $(this).val(), o = $(this).parent().find(".strength");
        if (t.length >= 6) {
            o.show();
            var l = verifyCheck.pwdStrong(t);
            o.find("b i").removeClass("on");
            for (var i = 0; i < l; i++) {
                o.find("b i").eq(i).addClass("on")
            }
        } else {
            o.hide()
        }
    })
});


/* tab 扫码二维码登录方式 */

var regTop = document.getElementById('reg-top');
var normal = document.getElementById('normal');
var nopw = document.getElementById('nopw');
var saoma = document.getElementById('qrcode');
var screen = document.getElementById('screen');
var rc = document.getElementById('rc');
var lc = document.getElementById('lc');
var sm = document.getElementById('sm');

var rcFlag = true;
var lcFlag = false;

normal.onclick = function () {
    rc.style.display = "block";
    lc.style.display = "none";
    sm.style.display = "none";
    regTop.style.display = "block";
    nopw.style.borderBottom = "none";
    normal.style.borderBottom = "1px solid rgb(1 114 229) ";
    nopw.style.color = "#666";
    normal.style.color = "rgb(1 114 229)  ";
    rcFlag = true;
    lcFlag = false;

}

nopw.onclick = function () {
    rc.style.display = "none";
    lc.style.display = "block";
    sm.style.display = "none";
    regTop.style.display = "block";
    nopw.style.borderBottom = "1px solid rgb(1 114 229) ";
    normal.style.borderBottom = "none";
    nopw.style.color = "rgb(1 114 229) ";
    normal.style.color = "#666";
    rcFlag = false;
    lcFlag = true;
}

// saoma.onclick = function () {
//     rc.style.display = "none";
//     lc.style.display = "none";
//     sm.style.display = "block";
//     regTop.style.display = "none";
// }
// screen.onclick = function () {
//     regTop.style.display = "block";
//     sm.style.display = "none";
//     if (rcFlag) {
//         rc.style.display = "block";
//         return;
//     } else {
//         rc.style.display = "none";
//     }
//     if (lcFlag) {
//         lc.style.display = "block";
//         return;
//     } else {
//         lc.style.display = "none";
//     }
// }


var rcInnerNum = document.getElementById('rc-inner-num');


var rcInnerVirity = document.getElementById('rc-inner-virity');


var inputPhone = document.getElementsByName('phone-num')[0];
var inputPassword = document.getElementsByName('password')[0];
var loginBtn = document.getElementById('login-btn');


var nFlag = false;


var innerNum = document.getElementById('inner-num');

var innerVirity = document.getElementById('inner-virity');

var selectList = document.getElementById('country');
var noPhoneNum = document.getElementsByName('phone-num')[1];
var otp = document.getElementsByName('password')[1];
var getcodeBtn = document.getElementById('getcode');
var loginBtn1 = document.getElementById('login-btn1');
var country = [' ',];


$(function () {
    // 浏览器检测
    IEVersion()
    //获取URL参数
    var error = GetQueryString("error")
    var mode = GetQueryString("mode")
    //判断普通登录的样式
    if (error == 'true' && mode != "sms") {
        $(".remember-count").css("margin-top", "40px")
    } else {
        $(".remember-count").css("margin-top", "25px")
    }
    //判断手机登录切换
    //普通登录
    if (mode == 'sms') {
        $("#show1").css("display", "none")
        $("#lc").css("display", "block")
        $("#nopw").css("border-bottom", "1px solid rgb(1, 114, 229)")
        $("#nopw").css("color", "rgb(1, 114, 229)")
        $("#normal").css("border-bottom", "none")
        $("#normal").css("color", "rgb(102, 102, 102)")
        $("#rc").css("display", "none")
    } else {
        //手机登录
        $("#show2").css("display", "none")
        $("#lc").css("display", "none")
        $("#nopw").css("border-bottom", "none")
        $("#nopw").css("color", "rgb(102, 102, 102)")
        $("#normal").css("border-bottom", "1px solid rgb(1, 114, 229)")
        $("#normal").css("color", "rgb(1, 114, 229)")
        $("#rc").css("display", "block")
    }
});

// url参数截取
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

/* 刷新验证码 */
function refreshCode() {
    $("#codes").attr("src", HTTP_BIZ_URI + '/code/image?time=' + $.now());
}

/* 获取验证码 */
function getSmsCode() {
    let mobile = $("#mobile").val();
    if ($.string.isEmpty(mobile)) {
        $.msg.msgWarning("请输入手机号码");
        return false;
    }
    $.ajax({
        url: HTTP_BIZ_URI + "/code/sms?mobile=" + mobile + "?time=" + $.now(),
        type: 'GET',
        cache: false,
        success: function (res) {
            $.msg.msgSuccess("验证码发送成功");
        },
        error: function () {
            $.msg.msgWarning("短信验证连接失败!!!");
        }
    });
}


//浏览器检测
function IEVersion() {
    let svg_ie = "<svg t='1587836980741' class='icon' style='width: 2em; height: 2em; vertical-align: middle; fill: currentcolor; overflow: hidden; font-size:30px;' viewBox='0 0 1024 1024' version='1.1' xmlns='http://www.w3.org/2000/svg' p-id='2422' width='32' height='32'><path d='M804.5 334c12.7-44 16.7-129.9-62.1-140.5C679 184.9 604 227.2 564.5 253.3c-13-1.8-26.6-3-41-3.1-102.7-1.3-169.4 33.6-225.9 107.5-20.8 27.2-39.3 73.3-45.1 125.6 29.2-49.6 116.3-139.1 209.9-175.9 0 0-140.5 100.4-209.4 243.7l-0.2 0.2c0.1 0.7 0.1 1.4 0.2 2.1-2.9 6.5-6 13-8.8 19.9-68.6 168.5-12.5 241.4 38.8 255 47.3 12.4 113.8-10.7 166.7-67.5 90.6 21.3 179.5-2.6 213.4-21.2 63.6-34.9 106.8-96.5 117-159.8L606.7 579.8c0 0-7.3 56.1-100.4 56.1-85.8 0-89.4-99.3-89.4-99.3l368.7 0c0 0 7-107-45.9-178.3-29.3-39.6-69.5-74.5-125.4-93.3 17.1-12.6 46.6-32.2 71.5-38.7 47.2-12.3 79.5-5 99.8 29.3 27.5 46.7-15.2 156-15.2 156S791.3 380 804.5 334zM423.6 753.4c-73 59.4-133.5 52.9-156.8 17.1-20.2-31.2-23.8-87.3-0.1-163.7 11.1 29.6 28.5 58.3 54.3 83.8C352.4 721.6 387.7 741.3 423.6 753.4zM420.9 444.9c0 0 3.7-70.4 80.2-76.8 66.8-5.5 101.3 23.6 111.6 80.2L420.9 444.9z' p-id='2423' fill='#51b72f' data-spm-anchor-id='a313x.7781069.0.i11'></path></svg>";
    let svg_thunder = "<svg t='1588218903014' class='icon' style='width: 1.5em; height: 1.5em; vertical-align: middle; fill: currentcolor; overflow: hidden; font-size: 30px;' viewBox='0 0 1024 1024' version='1.1' xmlns='http://www.w3.org/2000/svg' p-id='4411' width='30' height='30'><path d='M395.765 586.57H224.032c-22.421 0-37.888-22.442-29.91-43.38L364.769 95.274a32 32 0 0 1 29.899-20.608h287.957c22.72 0 38.208 23.018 29.632 44.064l-99.36 243.882h187.05c27.51 0 42.187 32.427 24.043 53.099l-458.602 522.56c-22.294 25.408-63.627 3.392-54.976-29.28l85.354-322.421z' p-id='4412' fill='#51b72f'></path></svg>";
    let htmls = "<div style='background-image:url(/static/assets/login/images/beij.jpg);width: 100%;height: 100vh'><div style='position:fixed;width: 100%;height: 100%;z-index:999999999999;font-size:30px;margin-top:19%;text-align: center'><p style='font-family: \"Microsoft YaHei\"' ></p><p style='font-family: \"Microsoft YaHei\"'><b style='font-weight: bolder;color: red; '>提示: </b>您的浏览器当前可能是'兼容模式'，请开启<b style='color:#51b72f'>极速模式</b><br>操作方式：点击浏览器地址栏右侧的IE符号" + svg_ie + "→选择“" + svg_thunder + "<b style='color:#51b72f;'>极速模式(推荐)</b><br><img src='http://182.254.205.150:8082/upload/428245601571192832/avatar/2021/1/20210113154639546759124625801216.png' style='width: 1200px;height: 85px'><br><b style=' color: #2b2b2b'>若无极速模式请更换: <b style='color:#51b72f'>360浏览器、火狐浏览器、谷歌浏览器</b></b></p></div><div style='position: fixed;bottom: 5%;text-align: center;width: 100%;color: #787878'></div></div>"
    let htmls2 = "<div style='background-image:url(/static/assets/login/images/beij.jpg);width: 100%;height: 100vh'><div style='position:fixed;width: 100%;height: 100%;z-index:999999999999;font-size:30px;;margin-top:19%;text-align: center'><p style=' font-family: \"Microsoft YaHei\"' ></p><p style='font-family: \"Microsoft YaHei\"'><b style='font-weight: bolder;color: red;'>温馨提示<br></b>推荐使用<b style='color:#51b72f'>" + svg_ie + "360浏览器、火狐浏览器、谷歌浏览器</b></div><div style='position: fixed;bottom: 5%;text-align: center;width: 100%;color: #787878'></div></div>"
    let userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    let isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1; //判断是否IE<11浏览器
    let isEdge = userAgent.indexOf("Edge") > -1 && !isIE; //判断是否IE的Edge浏览器
    if (isIE) {
        let reIE = new RegExp("MSIE (\\d+\\.\\d+);");
        reIE.test(userAgent);
        let fIEVersion = parseFloat(RegExp["$1"]);
        if (fIEVersion == 7) {
            var html = document.querySelector("html");
            html.innerHTML = htmls2;
            html.style.overflow = "hidden";
        } else if (fIEVersion == 8) {
            let html = document.querySelector("html");
            html.innerHTML = htmls2;
            html.style.overflow = "hidden";
        } else if (fIEVersion == 9) {
            let html = document.querySelector("html");
            html.innerHTML = htmls2;
            html.style.overflow = "hidden";
        } else if (fIEVersion == 10) {
            let html = document.querySelector("html");
            html.innerHTML = htmls2;
            html.style.overflow = "hidden";
        }
    } else if (isEdge) {
        let html = document.querySelector("html");
        html.innerHTML = htmls2;
        html.style.overflow = "hidden";
    }
    //判断是否兼容模式
    else if (navigator.userAgent.indexOf(".NET") > -1) {
        let html = document.querySelector("html");
        html.innerHTML = htmls;
        html.style.overflow = "hidden";
    }
}

