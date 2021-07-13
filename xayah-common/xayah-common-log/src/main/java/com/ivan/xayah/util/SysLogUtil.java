package com.ivan.xayah.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.ivan.xayah.entity.SysLog;
import com.ivan.xayah.tool.utils.UrlUtil;
import com.ivan.xayah.tool.utils.WebUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author ivan
 * @className LogUtil
 * @since 2021/3/11 22:42
 */
public class SysLogUtil {

    /**
     * 向log中添加补齐request的信息
     *
     * @param request     请求
     * @return
     */
    public static SysLog addRequestInfoToLog(HttpServletRequest request) {
        SysLog sysLog = new SysLog();
        sysLog.setRemoteAddr(WebUtil.getIP(request));
        sysLog.setUserAgent(request.getHeader(WebUtil.USER_AGENT_HEADER));
        sysLog.setRequestUri(UrlUtil.getPath(request.getRequestURI()));
        sysLog.setMethod(request.getMethod());
        sysLog.setParams(WebUtil.getRequestParamString(request));
        return sysLog;
    }

    /**
     * 向log中添加补齐其他的信息（eg：blade、server等）
     * @param sysLog
     */
    public static void addOtherInfoToLog(SysLog sysLog) {

        //这里判断一下params为null的情况，否则blade-log服务在解析该字段的时候，可能会报出NPE
        if (sysLog.getParams() == null) {
            sysLog.setParams(StrUtil.EMPTY);
        }
    }

}
