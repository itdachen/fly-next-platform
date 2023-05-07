/**
 * 响应状态码, 常量枚举, 不允许修改值, 可以添加新的枚举类型
 */
export const enum ResultStatusCode {
    /* 操作成功 */
    SUCCESS = 200,
    /* 操作失败 */
    ERROR = 500,
    /* 未知异常 */
    EXCEPTION = 500500,

    /* 没有操作权限 */
    TOKEN_FORBIDDEN_CODE = 401401,
    /* token 令牌异常 */
    EX_USER_INVALID_CODE = 40101,
    /* 用户认证异常 */
    CLIENT_TOKEN_EXCEPTION = 401100,
    /* 用户不存在 */
    NO_LOGIN_USER_INFO = 401404,
    /* 账号已被冻结 */
    LOCKED_ACCOUNT = 401500,
    /* 登录密码错误，请检查密码时候正确！ */
    USER_PASSWORD_NOT_MATCH = 401600,

    /* token 不存在或 token 过期！ */
    CLIENT_OVERDUE_EXCEPTION = 401402,

    /* 校验参数错误 */
    PARAMS_VALID = 400100,
    PARAMS_VALID_MSG = 400200,


}
