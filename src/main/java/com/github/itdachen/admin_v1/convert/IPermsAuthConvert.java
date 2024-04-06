package com.github.itdachen.admin_v1.convert;

import com.github.itdachen.admin_v1.entity.PermsAuth;
import com.github.itdachen.admin_v1.sdk.dto.PermsAuthDto;
import com.github.itdachen.admin_v1.sdk.vo.PermsAuthVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:41
 * Created with IntelliJ IDEA.
 */
public interface IPermsAuthConvert extends IBizConvertMapper<PermsAuth, PermsAuthDto, PermsAuthVo> {
}
