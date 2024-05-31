$(function () {

    initAppCard();

});


/**
 * 加载应用
 */
function initAppCard() {
    $.http.get({
        url: HTTP_BIZ_URI + '/admin/app/info/list',
        callback: function (res) {
            renderAppInfo(res.data);
        }
    })
}

/**
 * 应用页面渲染
 * @param data
 */
function renderAppInfo(data) {
    let html = '';
    let appLogo = HTTP_BIZ_URI + '/static/assets/fly/images/logo4.png';
    for (let i = 0; i < data.length; i++) {
        let bgImage = HTTP_BIZ_URI + '/static/assets/fly/images/' + i + '.png';
        if (i >= 10) {
            let a = i % 10;
            bgImage = HTTP_BIZ_URI + '/static/assets/fly/images/' + a + '.png';
        }
        // html += ' <div class="onClickTag" data-id="' + data[i].id + '" data-title="' + data[i].appTitle + '" \n' +
        //     '             style="background-image: url(' + bgImage + ');\n' +
        //     'background-size: 100% 100%;\n' +
        //     'width: 500px; height: 80px;\n' +
        //     'margin: 10px;' +
        //     'cursor: pointer  ">\n' +
        //     '            <div style="height: 80px; line-height: 80px;">\n' +
        //     '                <img src="/fly/static/assets/fly/images/logo4.png" style="margin-left: 30px; margin-bottom: 10px;">\n' +
        //     '                <span style="font-size: 20px;margin-left: 10px;color: #ffffff">' + data[i].appTitle + '</span>\n' +
        //     '            </div>\n' +
        //     '        </div>'


        html += '            <div class="layui-col-md3 onClickTag card-item-container"  data-id="' + data[i].id + '" data-title="' + data[i].appTitle + '" \n' +
            '                 style="background-image: url(' + bgImage + ');">\n' +
            '                    <div class="layui-card-body">\n' +
            '                        <div style="line-height: 50px;">\n' +
            '                            <img src="' + appLogo + '" style="margin-left: 20px; margin-bottom: 10px;">\n' +
            '                            <span style="font-size: 20px;margin-left: 10px;color: #ffffff">' + data[i].appTitle + '</span>\n' +
            '                        </div>\n' +
            '                </div>\n' +
            '            </div>'

    }

    $('#appBox').append(html);


    /* 点击卡片, 获取应用ID */
    $(".onClickTag").click(function () {
        let appId = $(this).attr("data-id");
        let appTitle = $(this).attr("data-title");
        flyerMenuFull(appId, appTitle);
    });


}


/**
 * 弹出菜单管理框
 * @param appId
 * @param appTitle
 */
function flyerMenuFull(appId, appTitle) {
    let uri = HTTP_BIZ_URI + '/admin/menu/info/app/' + appId + '/index';
    $.flyer.full(appTitle, uri);
}
