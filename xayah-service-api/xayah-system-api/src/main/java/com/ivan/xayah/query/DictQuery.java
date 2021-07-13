package com.ivan.xayah.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ivan.xayah.mybatis.base.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author ivan
 * @className DictQuery
 * @since 2021/3/10 21:29
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class DictQuery extends BaseQuery implements Serializable {

    /**
     * 分类编码
     */
    private String categoryCode;

    /**
     * 分类说明
     */
    private String categoryDesc;

}
