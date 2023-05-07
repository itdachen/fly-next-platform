import httpAxios from '/@/axios';

/**
 * （不建议写成 request.post(xxx)，因为这样 post 时，无法 params 与 data 同时传参）
 *
 * 登录api接口集合
 * @method signIn 用户登录
 * @method signOut 用户退出登录
 */
export function useLoginApi() {
    return {

        signIn: (params: object) => {
            return httpAxios.request({
                url: '/oauth/token',
                method: 'post',
                data: params,
            });

            // return request({
            // 	url: '/user/signIn',
            // 	method: 'post',
            // 	data,
            // });
        },

        signOut: (data: object) => {
            return httpAxios.request({
                url: '/user/signOut',
                method: 'post',
                data: data,
            });

            // return request({
            // 	url: '/user/signOut',
            // 	method: 'post',
            // 	data,
            // });
        },
    };
}
