package com.ivan.xayah.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 系统字典表
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_dict")
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "dict_id", type = IdType.AUTO)
    private Long dictId;

    /**
     * 字典编码
     */
    private String dictCode;

    /**
     * 字典值
     */
    private Integer dictValue;

    /**
     * 字典名称
     */
    private String dictDesc;

    /**
     * 分类编码
     */
    private String categoryCode;

    /**
     * 分类说明
     */
    private String categoryDesc;

    /**
     * 排序编号
     */
    private Integer sort;

    /**
     * 状态(0-禁用，1-启用)
     */
    private Integer status;

    /**
     * 创建人ID
     */
    private Long createUserId;

    /**
     * 修改人ID
     */
    private Long updateUserId;

    /**
     * 创建人姓名
     */
    private String createUserName;

    /**
     * 修改人姓名
     */
    private String updateUserName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
