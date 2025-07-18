package com.github.itdachen.ooxml.poi.exp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * WorkBookExpHelper
 *
 * @author 王大宸
 * @date 2025/7/19 1:51
 */
public class WorkBookExpHelper<T, Q> {
    private static final Logger logger = LoggerFactory.getLogger(WorkBookExpHelper.class);
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("work-book-exp-thread-" + ThreadLocalRandom.current().nextInt(1000));
            return thread;
        }
    });


    /**
     * 导出参数设置
     */
    private ParameterSettings<Q> settings;


    /**
     * 数据来源已经导入方法接口
     */
    private IWriteWorkBook<T, Q> writeWorkBook;


    /***
     * 创建表格方法
     */
    private ICreateWorkBook<T, Q> createWorkBook = new DefaultCreateWorkBook<>();

    public WorkBookExpHelper(ParameterSettings<Q> settings, IWriteWorkBook<T, Q> writeWorkBook) {
        this.settings = settings;
        this.writeWorkBook = writeWorkBook;
    }

    public WorkBookExpHelper(ParameterSettings<Q> settings, IWriteWorkBook<T, Q> writeWorkBook, ICreateWorkBook<T, Q> createWorkBook) {
        this.settings = settings;
        this.writeWorkBook = writeWorkBook;
        this.createWorkBook = createWorkBook;
    }


    public void helper() {

    }


}
