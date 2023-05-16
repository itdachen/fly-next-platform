import httpAxios from "/@/fly/axios";
import {OSS_URI} from "/@/fly/axios/conf/config";

/**
 * 文件上传
 */
export function fileUploader(file) {
    const params = new FormData()
    params.append('file', file.file)
    return httpAxios.request({
        method: 'POST',
        url: OSS_URI,
        headers: {'Content-Type': 'multipart/form-data'},
        data: params
    })
}