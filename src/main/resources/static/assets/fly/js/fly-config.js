/** 文件上传接口 */
const uploadURL = '/oss/file/upload';

/** 文件 MD5 校验接口, 后面接解析的文件 MD5  */
const uploadCheckMD5URL = '/oss/file/md5/';

/** 数据资料获取接口, 后面接字典类型 */
const dictDateApi = '/api/open/dict/data/';

/** 文件解析服务地址 */
const ONLINE_PREVIEW_URI = 'http://localhost:8012'

var uploadLayer;
var running = false;

/**
 * 后台返回状态码
 * @type {{PARAMS_VALID: number, SUCCESS: number, LOCKED_ACCOUNT: number, HTTP_EX: number, ERROR: number, PARAMS_VALID_MSG: number, NO_LOGIN_USER_INFO: number, USER_PASSWORD_NOT_MATCH: number, WARNING: number, CLIENT_TOKEN_EXCEPTION: number}}
 */
const STATUS_CODE = {
    SUCCESS: 200,
    ERROR: 500,
    WARNING: 400100,
    PARAMS_VALID: 400200,
    CLIENT_TOKEN_EXCEPTION: 400300,
    PARAMS_VALID_MSG: 10012,
    HTTP_EX: 400500,
    USER_PASSWORD_NOT_MATCH: 400600,
    NO_LOGIN_USER_INFO: 400400,
    LOCKED_ACCOUNT: 500200,
};

/**
 * layer 弹窗状态码
 * @type {{SUCCESS: string, HAPPY: string, UNHAPPY: string, LAYER_TIME: number, ERROR: string, CONFIRM: string, WARNING: string, LOCKUP: string}}
 */
const LAYER_STATUS = {
    WARNING: "warning",
    SUCCESS: "success",
    ERROR: "error",
    CONFIRM: "confirm",
    LOCKUP: "lockup",
    UNHAPPY: "unhappy",
    HAPPY: "happy",
    LAYER_TIME: 1500
};

/**
 * http 请求方法
 * @type {{DELETE: string, POST: string, GET: string, PUT: string}}
 */
const HTTP_METHOD = {
    GET: 'GET', POST: 'POST', PUT: 'PUT', DELETE: 'DELETE',
}