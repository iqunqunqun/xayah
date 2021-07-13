package com.ivan.xayah.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.ivan.xayah.mybatis.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_user")
public class SysUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long userId;

    /**
     * 用户编号
     */
    private String code;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String name;

    /**
     * 手机
     */
    private String phone;

    /**
     * 生日
     */
    private LocalDateTime birthday;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 部门id
     */
    private String deptId;


    /**
     * 状态(0-禁用，1-启用)
     */
    private Integer status;

    /**
     * 是否已删除(0-未删除，1-已删除)
     */
    private Integer deleted;


}
