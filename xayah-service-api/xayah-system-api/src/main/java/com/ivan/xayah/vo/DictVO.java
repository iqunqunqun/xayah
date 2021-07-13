package com.ivan.xayah.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p></p>
 *
 * @author ivan
 * @className DictVO
 * @since 2021/3/10 21:32
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class DictVO {

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
}
