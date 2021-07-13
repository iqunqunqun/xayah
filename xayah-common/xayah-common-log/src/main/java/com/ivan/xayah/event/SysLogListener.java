package com.ivan.xayah.event;

import com.ivan.xayah.entity.SysLog;
import com.ivan.xayah.feign.ISystemClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * <p></p>
 *
 * @author ivan
 * @className SysLogListener
 * @since 2021/3/10 22:14
 */

@Slf4j
@AllArgsConstructor
public class SysLogListener {


    private final ISystemClient systemClient;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        SysLog sysLog = (SysLog) event.getSource();
        systemClient.saveLog(sysLog);
    }


}
