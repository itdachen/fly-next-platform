import axios, {
    AxiosInstance,
    AxiosRequestConfig,
    AxiosResponse,
    AxiosResponseHeaders,
    ServerResponse
} from 'axios';
import {BASIC, TOKEN_TYPE, TIME_OUT, OPEN_URL, CONTENT_TYPE} from '/@/axios/conf/config';
import {ElMessage} from 'element-plus';
import useStringComposable from '/@/utils/string';
import {ResultStatusCode} from '/@/axios/enums/ResultStatusCode';
import {useRouter} from 'vue-router';
import {getToken} from '/@/axios/jwt/JwtService';

const {isEmpty, split} = useStringComposable();
const router = useRouter();

class ApiRequest {
    private instance: AxiosInstance;
    private readonly config: AxiosRequestConfig;

    constructor(option: AxiosRequestConfig) {
        this.config = option;
        // 配置全局参数
        this.instance = axios.create(this.config);
        this.interceptors();
    }

    private interceptors() {
        /**
         * 请求拦截器
         */
        this.instance.interceptors.request.use((config) => {
                removePending(config);
                addPending(config);
                let url: string | undefined = config.url;
                if (undefined == url) {
                    console.warn('请求路径不能为空');
                    url = '/404';
                }
                config.headers = basicHeaders();
                let strings = split(OPEN_URL, ',');
                let isOpen = false; // false 需要拦截, true 的时候, 是不需要拦截的
                for (let i = 0; i < strings.length; i++) {
                    if (url.indexOf(strings[i]) !== -1) {
                        isOpen = true;
                        break;
                    }
                }
                const token = getToken();
                // 需要认证 但是没有token的存在
                if (!isOpen && isEmpty(token)) {
                    ElMessage.error('请先登录');
                    // 清空本地缓存
                    localStorage.clear();
                    // 路由跳转
                    router.push('/login');
                }
                if (!isEmpty(token)) {
                    config.headers = {
                        'content-type': CONTENT_TYPE,
                        'Authorization': TOKEN_TYPE + token,
                    };
                }
                return config;
            }, (error) => Promise.reject(error),
        );

        /**
         * 相应拦截器
         */
        this.instance.interceptors.response.use((response: AxiosResponse<ServerResponse<any>>) => {
                removePending(response.config);
                if (200 === response.status && response.config.responseType === 'blob') {
                    //   response
                    return response;
                }
                const res = response.data;
                if (ResultStatusCode.SUCCESS === res.status) {
                    return res;
                }
                ElMessage.error(res.msg);
                /* 登录 token 异常, 这里加入路由前置守卫, 跳转到登录页面 */
                if (res.status === ResultStatusCode.CLIENT_TOKEN_EXCEPTION) {
                    // 清空本地缓存
                    localStorage.clear();
                    // 路由跳转
                    router.push('/login');
                }
                return Promise.reject(res);
            }, (error) => {
                error.config && removePending(error.config);
                httpErrorStatusHandle(error);
                return Promise.reject(error);
            },
        );
    }

    /**
     * 获取 token
     */
    // private getToken = () => {
    //     return localStorage.getItem('token') as string
    // }

    /**
     * 请求操作
     * @param config
     */
    request(config: AxiosRequestConfig): Promise<ServerResponse<any>> {
        return this.instance.request<ServerResponse<any>, ServerResponse<any>>(config);
    }

    /**
     * 文件下载
     * @param url     文件下载地址
     * @param method  请求方法
     */
    download({url = '', method = 'GET'}): void {
        this.instance.request({
            url: url,
            method: method,
            responseType: 'blob',
        }).then(res => {
            const headers: AxiosResponseHeaders = res.headers;//下载后文件名
            const contentDisposition = headers['content-disposition'] as string;
            const filename = decodeURI(contentDisposition.split(';')[1].split('filename=')[1]);
            const blob = new Blob([res.data], {type: res.headers['content-type']});
            const downloadElement = document.createElement('a');
            const href = URL.createObjectURL(blob); //创建下载的链接
            downloadElement.href = href;
            downloadElement.download = filename;
            document.body.appendChild(downloadElement);
            downloadElement.click(); //点击下载
            document.body.removeChild(downloadElement); //下载完成移除元素
            URL.revokeObjectURL(href); //释放掉blob对象
            return Promise.reject(res);
        }, err => {
            return Promise.reject(err);
        });
    }

    /**
     * get 请求路径
     * @param url 请求路径
     */
    get(url: string = '') {
        return this.request({
            url: url,
            method: 'GET',
        });
    }

    /**
     * post 请求
     * @param url  请求路径
     * @param data 请求参数
     */
    post(url: string = '', data: any = {}) {
        return this.request({
            url: url,
            method: 'POST',
            data: data,
        });
    }

    /**
     * put 请求
     * @param url   请求路径
     * @param data  请求参数
     */
    put(url: string = '', data: any = {}) {
        return this.request({
            url: url,
            method: 'PUT',
            data: data,
        });
    }

    /**
     * 删除请求
     * @param url 请求路径
     */
    delete(url: string = '') {
        return this.request({
            url: url,
            method: 'DELETE',
        });
    }


}

export default ApiRequest;

/**
 * 处理异常
 * @param {*} error
 */
function httpErrorStatusHandle(error: any) {
    //  const userStore = useUserStore()
    // 处理被取消的请求
    if (axios.isCancel(error)) return console.error('请求的重复请求：' + error.message);
    let message = '';
    if (error && error.response) {
        switch (error.response.status) {
            case 429:
                message = '访问人数太多 请稍后再试！';
                break;
            case 302:
                message = '接口重定向了！';
                break;
            case 400:
                message = '参数不正确！';
                break;
            case 401:
                message = '您未登录，或者登录已经超时，请先登录！';
                break;
            case 403:
                message = '您没有权限操作！';
                break;
            case 404:
                message = `请求地址出错: ${error.response.config.url}`;
                break; // 在正确域名下
            case 408:
                message = '请求超时！';
                break;
            case 409:
                message = '系统已存在相同数据！';
                break;
            case 500:
                message = '服务器内部错误！';
                break;
            case 501:
                message = '服务未实现！';
                break;
            case 502:
                message = '网关错误！';
                break;
            case 503:
                message = '服务不可用！';
                break;
            case 504:
                message = '服务暂时无法访问，请稍后再试！';
                break;
            case 505:
                message = 'HTTP版本不受支持！';
                break;
            default:
                message = '异常问题，请联系管理员！';
        }
    }
    if (error.message.includes('timeout')) {
        message = '网络请求超时！';
    }
    if (error.message.includes('Network')) {
        message = window.navigator.onLine ? '服务端异常！' : '您断网了！';
    }
    ElMessage({
        type: 'error',
        message,
    });
}

const pendingMap = new Map();

/**
 * 储存每个请求的唯一cancel回调, 以此为标识
 * @param {*} config
 */
function addPending(config: AxiosRequestConfig) {
    const pendingKey = getPendingKey(config);
    config.cancelToken = config.cancelToken || new axios.CancelToken((cancel) => {
        if (!pendingMap.has(pendingKey)) {
            pendingMap.set(pendingKey, cancel);
        }
    });
}

/**
 * 删除重复的请求
 * @param {*} config
 */
function removePending(config: AxiosRequestConfig) {
    const pendingKey = getPendingKey(config);
    if (pendingMap.has(pendingKey)) {
        const cancelToken = pendingMap.get(pendingKey);
        // 如你不明白此处为什么需要传递pendingKey可以看文章下方的补丁解释
        cancelToken(pendingKey);
        pendingMap.delete(pendingKey);
    }
}

/**
 * 生成唯一的每个请求的唯一key
 * @param config
 */
function getPendingKey(config: AxiosRequestConfig) {
    let {url, method, params, data} = config;
    if ('/oauth/token' === url && typeof data === 'string') {
        let str = data as string;
        data = '{"' + str.replaceAll('&', '\",\"').replaceAll('=', '":"') + '"}' as string;
    }
    if (typeof data === 'string') {
        data = JSON.parse(data);
    } // response里面返回的config.data是个字符串对象
    return [url, method, JSON.stringify(params), JSON.stringify(data)].join('&');
}

function basicHeaders() {
    return {
        //  'content-type': 'application/x-www-form-urlencoded',
        'content-type': CONTENT_TYPE,
        'Authorization': 'Basic aXRkYWNoZW5fZmFzdDppdGRhY2hlbl9mYXN0',
    };
}
