import { Session } from '/@/utils/storage';

const ID_TOKEN_KEY = 'id_token' as string;

/**
 * 从localStorage获取令牌
 */
export const getToken = (): string | null => {
	return Session.get('token');
//    return window.localStorage.getItem(ID_TOKEN_KEY);
};

/**
 * 将令牌保存到本地存储
 * @param token: 令牌
 */
export const saveToken = (token: string): void => {
	return Session.set('token', token);
//	window.localStorage.setItem(ID_TOKEN_KEY, token);
};

/**
 * 从本地存储中删除令牌
 */
export const destroyToken = (): void => {
	Session.clear();
	//   window.localStorage.removeItem(ID_TOKEN_KEY);
};

export default { getToken, saveToken, destroyToken };