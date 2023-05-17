import {reactive, ref} from "vue";
import {ElTree} from "element-plus";

/**
 * 树结构数据
 */
export interface ElTreeModel {
    /* 展示的数据内容 */
    data: any[],
    /* 回显的数据 */
    checked: string[] | number[]
}

/**
 * 后端返回通用树数据结构
 */
export interface TreeNode {
    id: string | number,
    title: string,
    children?: TreeNode[]
}


/**
 * Element-plus 控件处理
 */
export default function useElTreeComposable() {

    /**
     * 树空间数据初始化
     */
    const elTreeData = reactive<ElTreeModel>({
        data: [],
        checked: []
    })

    /**
     * 树的 ref 属性
     */
    const refTree = ref<InstanceType<typeof ElTree>>();

    /**
     * 组件的ref属性
     */
    const refTreePopup = ref<{ show: (treeDate: ElTreeModel, title: string) => void }>()

    /**
     * 获取选择的末节点
     * @param checkedNode 后端返回的选择阶段
     * @param data        后端返回的树结构数据
     * @param children    data 的 子节点, 默认是 children 属性
     * @return 字符串类型的数据集合
     */
    const getCheckedNode = (checkedNode: string[] | number[], data: any[], children = 'children'): string[] => {
        if (null === checkedNode || undefined === checkedNode || 0 === checkedNode.length) {
            return [];
        }
        const node: string[] = [];
        checkedNode.forEach((item: string | number) => {
            checked(item, data, node, children);
        })
        return node;
    }

    return {
        refTree,
        refTreePopup,
        elTreeData,
        getCheckedNode
    }

}

/**
 * 遍历, 获取末端选中节点
 * @param id        后端选中的数据id
 * @param data      tree 树结构数据
 * @param newArr    末端选中节点数组
 * @param children  子菜单名称, 默认是 children
 */
export function checked(id: string | number, data: any, newArr: string[], children = 'children') {
    data.forEach((item: { id: string; children: any[]; }) => {
        if (item.id == id) {
            if (!item.children || 0 === item.children.length) {
                newArr.push(item.id)
            }
        } else {
            if (item.children.length != 0) {
                checked(id, item.children, newArr, children)
            }
        }
    });
}
