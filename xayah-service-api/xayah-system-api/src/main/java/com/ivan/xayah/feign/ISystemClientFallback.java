package com.ivan.xayah.feign;

import com.ivan.xayah.entity.SysLog;

/**
 * <p></p>
 *
 * @author ivan
 * @className ISystemClientFallback
 * @since 2021/3/10 22:45
 */
public class ISystemClientFallback implements ISystemClient{
    @Override
    public Boolean saveLog(SysLog sysLog) {
        return null;
    }
}
