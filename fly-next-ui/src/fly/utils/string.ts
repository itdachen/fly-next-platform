/**
 * 字符串操作
 */

export default function useStringComposable() {

    /**
     * 判断是否为空
     * @param str
     */
    const isEmpty = (str: string | undefined | null): boolean => {
        return (null === str || 'null' === str || 'NULL' === str
            || undefined === str || 'undefined' === str || 'UNDEFINED' === str
            || '' === str || '' === str.trim());
    }

    /**
     * 判断是否不为空
     * @param str
     */
    const isNotEmpty = (str: string): boolean => {
        return !isEmpty(str);
    }

    /**
     * 将字符串通过符号分开,返回数组
     * @param str  需要分开的字符串
     * @param char  符号
     */
    const split = (str: string | null, char: string): string[] => {
        if (null == str) {
            return [];
        }
        return str.split(char);
    }


    return {
        isEmpty,
        isNotEmpty,
        split
    }
}