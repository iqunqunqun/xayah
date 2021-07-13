package com.ivan.xayah.aspect;

import com.ivan.xayah.entity.SysLog;
import com.ivan.xayah.event.SysLogEvent;
import com.ivan.xayah.tool.init.dict.DictUtil;
import com.ivan.xayah.tool.utils.SpringUtil;
import com.ivan.xayah.tool.utils.WebUtil;
import com.ivan.xayah.util.SysLogUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author ivan
 * @className SysLogAspect
 * @since 2021/3/10 22:12
 */

@Slf4j
@Aspect
public class SysLogAspect {
    @Autowired
    private DictUtil dictUtil;


    @Around(value = "@annotation(sysLog)")
    @SneakyThrows
    public Object around(ProceedingJoinPoint point, com.ivan.xayah.annotation.SysLog sysLog) {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);
        SysLog log = SysLogUtil.addRequestInfoToLog(WebUtil.getRequest());
        log.setTitle(sysLog.value());
        log.setType(dictUtil.getValueByCategoryAndDict("logType", "normal").toString());
        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj;

        try {
            obj = point.proceed();
        }
        catch (Exception e) {
            log.setType(dictUtil.getValueByCategoryAndDict("logType", "error").toString());
            log.setException(e.getMessage());
            throw e;
        }
        finally {
            Long endTime = System.currentTimeMillis();
            log.setTime(String.valueOf(endTime - startTime));
            SpringUtil.publishEvent(new SysLogEvent(log));
        }

        return obj;
    }

}
