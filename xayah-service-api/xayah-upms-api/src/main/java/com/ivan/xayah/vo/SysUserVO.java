package com.ivan.xayah.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author ivan
 * @className SysUserVO
 * @since 2021/3/7 17:52
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserVO {

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

}
