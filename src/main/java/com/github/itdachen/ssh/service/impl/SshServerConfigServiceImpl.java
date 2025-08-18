package com.github.itdachen.ssh.service.impl;

import com.github.itdachen.boot.oplog.ooxml.poi.exp.utils.ExcelExpUtils;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.framework.webmvc.poi.WorkBookUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.ssh.entity.SshServerConfig;
import com.github.itdachen.ssh.sdk.dto.SshServerConfigDTO;
import com.github.itdachen.ssh.sdk.query.SshServerConfigQuery;
import com.github.itdachen.ssh.sdk.vo.SshServerConfigVO;
import com.github.itdachen.ssh.mapper.ISshServerConfigMapper;
import com.github.itdachen.ssh.service.ISshServerConfigService;
import com.github.itdachen.ssh.convert.SshServerConfigConvert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * SSH 连接 业务实现
 *
 * @author 王大宸
 * @date 2025-08-18 22:58:10
 */
@Service
public class SshServerConfigServiceImpl extends BizServiceImpl< ISshServerConfigMapper, SshServerConfig, SshServerConfigDTO,  SshServerConfigVO, SshServerConfigQuery, String > implements ISshServerConfigService {
    private static final Logger logger = LoggerFactory.getLogger(SshServerConfigServiceImpl.class);
    private static final SshServerConfigConvert bizConvert = new SshServerConfigConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();
    public SshServerConfigServiceImpl() {
        super(bizConvert);
            EXP_FIELDS.add("连接名称");
            EXP_FIELDS.add("连接IP");
            EXP_FIELDS.add("连接端口");
            EXP_FIELDS.add("登录账号");
    }

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2025-08-18 22:58:10
    * @param params params
    * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.ssh.sdk.vo.sshServerConfigVo>
    */
    @Override
    public TableData< SshServerConfigVO > page(SshServerConfigQuery params) throws Exception {
        Page< SshServerConfigVO > page = PageHelper.startPage(params.getPage(), params.getLimit());
        List< SshServerConfigVO > list = bizMapper.list(params);
        return new TableData< SshServerConfigVO >(page.getTotal(), list);
    }


    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-08-18 22:58:10
     * @param params com.github.itdachen.ssh.sdk.query.SshServerConfigQuery
     * @return void
     */
    @Override
    public void expInfo(HttpServletRequest request,
                               HttpServletResponse response,
                               SshServerConfigQuery params) throws Exception{

//        List < LinkedHashMap < String, String > >  list = bizMapper.selectSshServerConfigExpData(params);
//       WorkBookUtils.export(request, response)
//                .params(params)
//                .title("SSH 连接")
//                .rowNum(true)
//                .fields(EXP_FIELDS)
//                .data(list)
//                .execute();


    }


    /***
     * 数据写入表格具体实现
     *
     * @author 王大宸
     * @date 2025-08-18 22:58:10
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List< SshServerConfigVO > list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
            SshServerConfigVO sshServerConfigVO = new SshServerConfigVO();
        for (int i = 0; i < list.size(); i++) {
                sshServerConfigVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
                ExcelExpUtils.setCellValue(row, 1, sshServerConfigVO.getSshTitle(), textCellStyle); // 连接名称
                ExcelExpUtils.setCellValue(row, 2, sshServerConfigVO.getHostIp(), textCellStyle); // 连接IP
                ExcelExpUtils.setCellValue(row, 3, sshServerConfigVO.getHostPort(), textCellStyle); // 连接端口
                ExcelExpUtils.setCellValue(row, 4, sshServerConfigVO.getHostUsername(), textCellStyle); // 登录账号
        }
    }

}
