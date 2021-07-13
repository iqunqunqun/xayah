package com.ivan.xayah.feign;

import com.ivan.xayah.entity.SysLog;
import com.ivan.xayah.tool.constant.AppConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * <p></p>
 *
 * @author ivan
 * @className ISystemLogClient
 * @since 2021/3/10 22:44
 */
@FeignClient(value = AppConstant.SYSTEM_APP_NAME, fallback = ISystemClientFallback.class)
public interface ISystemClient {

    /**
     * 保存日志
     * @param sysLog 日志实体
     * @return succes、false
     */
    @PostMapping("/sys-log")
    Boolean saveLog(@RequestBody SysLog sysLog);
}
