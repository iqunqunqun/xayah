package com.ivan.xayah.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *     日志注解
 * </p>
 *
 * @author ivan
 * @className ApiLog
 * @since 2021/3/10 22:11
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    /**
     * 日志描述
     *
     * @return {String}
     */
    String value() default "日志记录";
}
