package com.github.itdachen.ooxml.poi.exp;


/**
 * 创建表格
 *
 * @author 王大宸
 * @date 2025/7/11 23:39
 */
public interface ICreateWorkBook<T, Q> {


    void createWorkBook(ParameterSettings<Q> settings, IWriteWorkBook<T, Q> handler, int bookNum, String msgId);


}
