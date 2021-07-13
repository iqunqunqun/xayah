package com.ivan.xayah.tool.init.dict;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author ivan
 * @className DictItem
 * @since 2021/3/7 22:49
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class DictItem implements Serializable {

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

}
