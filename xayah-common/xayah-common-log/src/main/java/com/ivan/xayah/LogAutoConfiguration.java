package com.ivan.xayah;

import com.ivan.xayah.aspect.SysLogAspect;
import com.ivan.xayah.event.SysLogListener;
import com.ivan.xayah.feign.ISystemClient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <p>日志配置类</p>
 *
 * @author ivan
 * @className LogAutoConfiguration
 * @since 2021/3/14 16:29
 */

@EnableAsync
@RequiredArgsConstructor
@ConditionalOnWebApplication
@Configuration(proxyBeanMethods = false)
public class LogAutoConfiguration {

    private final ISystemClient systemClient;

    @Bean
    public SysLogListener sysLogListener() {
        return new SysLogListener(systemClient);
    }

    @Bean
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }


}
