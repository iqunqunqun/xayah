package com.ivan.xayah.dto;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ivan.xayah.entity.SysDict;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author ivan
 * @className SysDictDTO
 * @since 2021/3/7 19:43
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class SysDictDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public static SysDict convert(SysDictDTO dictDTO) {
        SysDict sysDict = new SysDict();
        BeanUtil.copyProperties(dictDTO, sysDict);
        return sysDict;
    }

}
