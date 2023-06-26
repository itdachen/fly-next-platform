package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.AppClient;
import com.github.itdachen.admin.sdk.dto.AppClientDto;
import com.github.itdachen.admin.sdk.vo.AppClientVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:29
 * Created with IntelliJ IDEA.
 */
public interface IAppClientConvert extends IBizConvertMapper<AppClient, AppClientDto, AppClientVo> {


    AppClient toJavaObject(AppClientVo appClientVo);

    AppClientVo toJavaObjectVo(AppClientDto appClientDto);

}
