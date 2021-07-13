package com.ivan.xayah.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ivan.xayah.mybatis.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 日志表
 * </p>
 *
 * @author ivan
 * @since 2021-03-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_log")
public class SysLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 日志类型
     */
    private String type;

    /**
     * 日志标题
     */
    private String title;

    /**
     * 服务ID
     */
    private String serviceId;


    /**
     * 操作IP地址
     */
    private String remoteAddr;

    /**
     * 用户代理
     */
    private String userAgent;

    /**
     * 请求URI
     */
    private String requestUri;

    /**
     * 操作方式
     */
    private String method;

    /**
     * 操作提交的数据
     */
    private String params;

    /**
     * 执行时间
     */
    private String time;

    /**
     * 异常信息
     */
    private String exception;

    /**
     * 创建者
     */
    private Long createUserId;

    /**
     * 创建者
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
