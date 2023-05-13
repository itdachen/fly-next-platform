/**
 * 连接超时
 */
const TIME_OUT = 10000;

/**
 * SpringSecurity OAuth2 认证时, 需要携带的客户端认证
 * 加密地址: http://web.chacuo.net/safebasicauth
 */
const CLIENT_SECRET = 'aXRkYWNoZW5fZmFzdDppdGRhY2hlbl9mYXN0';

/**
 * 不需要携带 token 的请求路径
 */
const OPEN_URL = 'oauth/token,/auth/oauth/access_token,/login,/oauth/token,/api/oauth/token,/api/open,/api/admin/open,/auth/oauth/jwt/token,/auth/oauth/jwt/refresh';

/**
 * 不携带 token 时的客户端秘钥
 */
const BASIC = 'Basic aXRkYWNoZW5fZmFzdDokMmEkMTAkQmRrMkZoLlIyU0hZWklOU24uZ3RyLjdlZHlHdXVyWHltRVppeDlJRHE0Y0JEb3lPQ1cxMGU=';

/**
 * token 前缀
 */
const TOKEN_TYPE = 'Bearer ';

const CONTENT_TYPE = 'application/json;charset=UTF-8'


export {TIME_OUT, OPEN_URL, BASIC, TOKEN_TYPE, CONTENT_TYPE}
