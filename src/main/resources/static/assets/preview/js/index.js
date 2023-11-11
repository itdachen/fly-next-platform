/* 需要解析的格式 */
const onlineViewType = ['doc', 'docx', 'xls', 'xlsx', 'xlsm', 'ppt', 'pptx', 'zip', 'rar',
    'txt', 'html', 'htm', 'xml', 'java', 'properties', 'asp', 'jsp', 'json', 'md', 'mp3',
    'gitignore', 'c', 'css', 'sql', 'js', 'conf', 'php', 'vue', 'py', 'sh', 'bat', 'log',
    'cpp', 'bas', 'cmd', 'prg', 'mp4', 'mp3'
]

/* 不需要解析即可查看的文件类型 */
const onlinePreviewFile = ['png', 'jpg', 'jpeg', 'bmp', 'gif', 'mp4', 'pdf'];

$(function () {
    let uri = $("#uri").val();

    let fileTypeName = uri.substring(uri.lastIndexOf('.') + 1, uri.length).split('?')[0];
    let onlinePreview = onlinePreviewFile.find((type) => type === fileTypeName);
    /* 直接在线解析 */
    if (onlinePreview) {
        $("#preview-box").html("<iframe src='" + uri + "'  width='100%' height='900px' frameborder='0'></iframe>")
        return;
    }
    /* 通过服务器解析 */
    let onlineOfficePreview = onlineViewType.find((type) => type === fileTypeName);
    if (onlineOfficePreview) {
        $("#preview-box").html(loadingHtml('由于文件过大, 如果出现 【 504 Gateway Time-out 】 错误, 请在五分钟之后重试！'))
        parent.location.href = ONLINE_PREVIEW_URI + '/onlinePreview?url=' + encodeURIComponent(Base64.encode(uri))
        return;
    }

    /* 不支持在线预览, 提示下载 */
    $("#preview-box").html(downloadFile(uri))

});


/**
 * loading 动态 html
 * @returns {string}
 */
function loadingHtml(str) {
    let html = '<div id="loading">\n' +
        '<div class="text-wrapper">\n' +
        ' <div class="text part1">\n' +
        '  <div>\n' +
        '   <span class="letter"><div class="character">L</div> <span></span></span>\n' +
        '   <span class="letter"><div class="character">o</div> <span></span></span>\n' +
        '   <span class="letter"><div class="character">a</div> <span></span></span>\n' +
        '   <span class="letter"><div class="character">d</div> <span></span></span>\n' +
        '   <span class="letter"><div class="character">i</div> <span></span></span>\n' +
        '   <span class="letter"><div class="character">n</div> <span></span></span>\n' +
        '   <span class="letter"><div class="character">g</div> <span></span></span>\n' +
        '  </div>\n' +
        '  </div>\n' +
        '  <div class="how-to"><span>正在加载中，请您耐心等待...</span></div>\n';

    if (undefined !== str && null != str && '' !== str) {
        html += '<div class="how-to"><span>' + str + '</span></div>\n';
    }
    html += '</div></div>';
    return html;
}

/**
 * 不支持预览,下载提示
 * @param url  文件地址
 * @returns {string}
 */
function downloadFile(url) {
    return ' <div class="d-content">\n' +
        '        <div class="macqq">\n' +
        '           该文件不支持在线预览, 请点击下载后预览: <a href="#" onClick="downloadFileFun(\'' + url + '\');">立即下载</a>。\n' +
        '        </div>\n' +
        '    </div>'
}

/**
 * 下载文件
 * @param url 文件下载地址
 */
function downloadFileFun(url) {
    if (undefined === url || null === url
        || '' === url || ' ' === url) {
        alert('文件地址不存在')
        return false;
    }
    window.open(url);
}