package com.example.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

class BizHandle extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(SimpleMDC.class);
    public static final String REQ_ID = "REQ_ID";

    private String funCode;

    public BizHandle(String funCode) {
        this.funCode = funCode;
    }

    @Override
    public void run() {
        MDC.put(REQ_ID, UUID.randomUUID().toString());
        logger.info("开始调用服务{}，进行业务处理", funCode);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }
        logger.info("服务{}处理完毕，可以释放空间了，避免内存泄露", funCode);
        MDC.remove(REQ_ID);
    }
}
