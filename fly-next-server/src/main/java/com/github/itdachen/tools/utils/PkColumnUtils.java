package com.github.itdachen.tools.utils;

import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.tools.sdk.vo.TableColumnVo;
import com.github.itdachen.tools.sdk.vo.TableInfoVo;

/**
 * Description:
 * Created by 王大宸 on 2023/04/10 21:57
 * Created with IntelliJ IDEA.
 */
public class PkColumnUtils {

    public static void setPkColumn(TableInfoVo table) {
        for (TableColumnVo column : table.getColumns()) {
            if (column.isPk()) {
                table.setPkColumn(column);
                break;
            }
        }
        if (StringUtils.isNull(table.getPkColumn())) {
            table.setPkColumn(table.getColumns().get(0));
        }

    }


}
