package com.ivan.xayah.entity;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ivan.xayah.mybatis.base.BaseEntity;
import com.ivan.xayah.tool.init.dict.DictItem;
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
public class SysDict extends BaseEntity implements Serializable {

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

    public static DictItem convert2DictItem(SysDict sysDict) {
        DictItem dictItem = new DictItem();
        BeanUtil.copyProperties(sysDict, dictItem);
        return dictItem;
    }


}
