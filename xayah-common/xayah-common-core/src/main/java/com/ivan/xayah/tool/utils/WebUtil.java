package com.ivan.xayah.tool.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

/**
 * <p></p>
 *
 * @author ivan
 * @className WebUtil
 * @since 2021/3/11 22:53
 */
public class WebUtil extends WebUtils {

    public static final String USER_AGENT_HEADER = "user-agent";

    public static final String UN_KNOWN = "unknown";

    /**
     * 获取 HttpServletRequest
     *
     * @return {HttpServletRequest}
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (requestAttributes == null) ? null : ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    /**
     * 获取ip
     *
     * @return {String}
     */
    public static String getIP() {
        return getIP(WebUtil.getRequest());
    }

    /**
     * 获取ip
     *
     * @param request HttpServletRequest
     * @return {String}
     */
    @Nullable
    public static String getIP(HttpServletRequest request) {
        Assert.notNull(request, "HttpServletRequest is null");
        String ip = request.getHeader("X-Requested-For");
        if (StrUtil.isBlank(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (StrUtil.isBlank(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StrUtil.isBlank(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StrUtil.isBlank(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StrUtil.isBlank(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StrUtil.isBlank(ip) || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return StrUtil.isBlank(ip) ? null : ip.split(",")[0];
    }


    /***
     * 获取 request 中 json 字符串的内容
     *
     * @param request request
     * @return 字符串内容
     */
    public static String getRequestParamString(HttpServletRequest request) {
        try {
            return getRequestStr(request);
        } catch (Exception ex) {
            return StrUtil.EMPTY;
        }
    }

    /**
     * 获取 request 请求内容
     *
     * @param request request
     * @return String
     * @throws IOException IOException
     */
    public static String getRequestStr(HttpServletRequest request) throws IOException {
        String queryString = request.getQueryString();
        if (StrUtil.isNotBlank(queryString)) {
            return new String(queryString.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).replaceAll("&amp;", "&").replaceAll("%22", "\"");
        }
        return getRequestStr(request, getRequestBytes(request));
    }

    /**
     * 获取 request 请求的 byte[] 数组
     *
     * @param request request
     * @return byte[]
     * @throws IOException IOException
     */
    public static byte[] getRequestBytes(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte[] buffer = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {

            int readlen = request.getInputStream().read(buffer, i, contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }

    /**
     * 获取 request 请求内容
     *
     * @param request request
     * @param buffer buffer
     * @return String
     * @throws IOException IOException
     */
    public static String getRequestStr(HttpServletRequest request, byte[] buffer) throws IOException {
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = CharsetUtil.UTF_8;
        }
        String str = new String(buffer, charEncoding).trim();
        if (StrUtil.isBlank(str)) {
            StringBuilder sb = new StringBuilder();
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String key = parameterNames.nextElement();
                String value = request.getParameter(key);
                StrUtil.appendIfMissing(sb, key, "=", value, "&");
            }
            str = StrUtil.removeSuffix(sb.toString(), "&");
        }
        return str.replaceAll("&amp;", "&");
    }

}
