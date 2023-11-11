var uploadLayer;
var running = false;

/**
 * 文件上传, 校验 md5
 * @param options
 */
function uploadMd5(options) {
    if ($.string.isEmpty(options.id)) {
        options.id = 'uploadMd5'
    }
    if ($.string.isEmpty(options.elem)) {
        options.elem = '#' + options.id;
    }
    if ($.string.isEmpty(options.url)) {
        options.url = uploadUrl + upload_type.FILE_OTHER;
    }
    if ($.string.isEmpty(options.accept)) {
        options.accept = "file";
    }
    if ($.string.isEmpty(options.multiple)) {
        options.multiple = true;
    }
    if ($.string.isEmpty(options.method)) {
        options.method = 'POST';
    }
    if ($.string.isEmpty(options.auto)) {
        options.auto = false;
    }

    /* 校验 MD5 成功之后,回调 */
    if ($.string.isEmpty(options.md5Callback)) {
        options.md5Callback = function (res) {
            layer.close(uploadLayer);
            console.log('请添加 md5Callback 回调函数 ... ')
            console.log(res)
        }
    }
    /* 正常上传回调 */
    if ($.string.isEmpty(options.callback)) {
        options.callback = function (res) {
            layer.close(uploadLayer);
            console.log('请添加 callback 回调函数 ... ')
            console.log(res)
        }
    }
    if ($.string.isEmpty(options.choose)) {
        options.choose = function (obj) {
            uploadLayer = layer.load(); // 上传loading
            $(".layui-layer-shade").css('background', '#000000')
            $(".layui-layer-shade").css('opacity', '0.2')
            obj.preview(function (index, file, result) {
                doCheckMd5(index, file, obj, options.md5Callback);
            })
        }
    }
    if ($.string.isEmpty(options.done)) {
        options.done = function (res) {
            layer.close(uploadLayer);
            options.callback(res);
        }
    }
    if ($.string.isEmpty(options.error)) {
        options.error = function (res) {
            layer.msg("文件上传服务连接失败,请联系技术人员!", {icon: $.modal.icon(modal_status.ERROR), time: 1500});
        }
    }
    upload.render(options);
}


function doShowFile() {
    let name;
    let url = $("#fileUrl").val().split(",");
    for (let i = 0; i < datas.length; i++) {
        if (datas[i] == null) {
            continue;
        }
        if (url.indexOf(datas[i].url) != -1) {
            continue;
        }
        name = datas[i].url.split(".");
        if (name[name.length - 1] == 'doc' || name[name.length - 1] == 'docx') {
            $("#file").before("<div id='delete" + index + "' class='con'><div class='delete' shiro:hasPermission=\"upload:index:del\" onclick='deleteFile(" + index + ")'>×</div><img src='/static/home/common/images/word.png'/><div>" + datas[i].name + "</div></div>")
        } else if (name[name.length - 1] == 'xls' || name[name.length - 1] == 'xlsx') {
            $("#file").before("<div id='delete" + index + "' class='con'><div class='delete' shiro:hasPermission=\"upload:index:del\" onclick='deleteFile(" + index + ")'>×</div><img src='/static/home/common/images/Excl.png'/><div>" + datas[i].name + "</div></div>")
        } else if (name[name.length - 1] == 'ppt' || name[name.length - 1] == 'pptx') {
            $("#upload").before("<div id='delete" + index + "' class='con'><div class='delete' shiro:hasPermission=\"upload:index:del\" onclick='deleteFile(" + index + ")'>×</div><img src='/static/home/common/images/ppt.png'/><div>" + datas[i].name + "</div></div>")
        } else if (name[name.length - 1] == "avi" || name[name.length - 1] == "MP4"
            || name[name.length - 1] == "wmv" || name[name.length - 1] == "3gp"
            || name[name.length - 1] == "mov" || name[name.length - 1] == "flv"
            || name[name.length - 1] == "ogg" || name[name.length - 1] == "mp4") {
            $("#upload").before("<div id='delete" + index + "' class='con'><div class='delete' shiro:hasPermission=\"upload:index:del\" onclick='deleteFile(" + index + ")'>×</div><img src='/static/home/common/images/video.png'/><div>" + datas[i].name + "</div></div>")
        } else if (name[name.length - 1] == 'rar' || name[name.length - 1] == 'zip') {
            $("#file").before("<div id='delete" + index + "' class='con'><div class='delete' shiro:hasPermission=\"upload:index:del\" onclick='deleteFile(" + index + ")'>×</div><img src='/static/home/common/images/rar.png'/><div>" + datas[i].name + "</div></div>")
        } else if (name[name.length - 1] == 'pdf') {
            $("#file").before("<div id='delete" + index + "' class='con'><div class='delete' shiro:hasPermission=\"upload:index:del\" onclick='deleteFile(" + index + ")' >×</div><img src='/static/home/common/images/pdf.png'/><div>" + datas[i].name + "</div></div>")
        } else if (name[name.length - 1] == 'png' || name[name.length - 1] == 'jpg'
            || name[name.length - 1] == 'pneg' || name[name.length - 1] == 'jpeg'
            || name[name.length - 1] == 'bmp' || name[name.length - 1] == 'JPG'
            || name[name.length - 1] == 'PNG') {
            $("#upload").before("<div id='delete" + index + "' class='con'><div class='delete' shiro:hasPermission=\"upload:index:del\" onclick='deleteFile(" + index + ")' >×</div><img style='width: 64px;height: 64px;cursor: pointer' onclick='openImages(&#039" + datas[i].url + "&#039);' src='" + datas[i].url + "'/><div>" + datas[i].name + "</div></div>")
        }
        if ($.string.isEmpty($("#fileUrl").val())) {
            $("#fileUrl").val(datas[i].url);
            $("#fileName").val(datas[i].name.slice(0, datas[i].name.lastIndexOf(".")));
        } else {
            $("#fileUrl").val($("#fileUrl").val() + "," + datas[i].url);
            $("#fileName").val($("#fileName").val() + "," + datas[i].name.slice(0, datas[i].name.lastIndexOf(".")));
        }
        layer.msg("文件上传成功！", {icon: $.modal.icon(modal_status.SUCCESS)});
        index++;
    }
}


/**
 * 文件 MD5 校验, 实现秒传
 * 如果服务器存在 md5 ,则不上传
 * 如果服务器不存在 md5, 则文件重新上传
 * @param index       下标
 * @param file        需要上传的文件
 * @param obj         layui 文件上传
 * @param callback    回调函数
 */
function doCheckMd5(index, file, obj, callback) {
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
                url: fileMd5HexUrl + md5Hex,
                async: false,
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