/**
 * 将普通列表转换为树结构的列表
 * @param list
 */
export function toTreeArr(list: any[]): any[] {
    if (!list || !list.length) {
        return []
    }
    let treeListMap = {};
    for (let item of list) {
        treeListMap[item.id] = item
    }
    for (let i = 0; i < list.length; i++) {
        if (list[i].parentId && treeListMap[list[i].parentId]) {
            if (!treeListMap[list[i].parentId].children) {
                treeListMap[list[i].parentId].children = []
            }
            treeListMap[list[i].parentId].children.push(list[i]);
            list.splice(i, 1);
            i--
        }
    }
    return list
}