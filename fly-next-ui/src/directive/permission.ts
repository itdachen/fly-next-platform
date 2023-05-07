import {Directive} from 'vue'
import useStringComposable from "/@/utils/string";

const {split} = useStringComposable()
/**
 * 自定义指令 --> 权限校验
 */
export const permission: Directive = {
    mounted(el, binding) {
        // value按钮上的权限
        const {value} = binding;

        /* 从本地获取权限 */
        const permissions: string | null = localStorage.getItem("permissions");

        const list = split(permissions, ',');
        // console.log('所有的权限')
        // console.log(list)

        //判断传递进来的按钮权限，是否存在
        if (value && value instanceof Array && value.length > 0) {
            const permissionRoles = value;
            //判断传递进来的按钮权限字段，是否存在当前用户的permissions
            const hasPermission = list.some((role) => {
                return permissionRoles.includes(role)
            })
            if (!hasPermission) { //没有权限时，影藏
                el.style.display = 'none'
            }
        } else {
            throw new Error('need roles! Like v-permission="[\'add\',\'edit\']"')
        }
    }
}