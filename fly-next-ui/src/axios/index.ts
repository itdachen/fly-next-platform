import {TIME_OUT} from "/@/axios/conf/config";
import ApiRequest from "/@/axios/interceptor/AxiosInterceptors";

const httpAxios = new ApiRequest({
    baseURL: "/api",
    timeout: TIME_OUT,
})

export default httpAxios
