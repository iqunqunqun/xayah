package com.ivan.xayah.mybatis.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author ivan
 * @className BaseQuery
 * @since 2021/3/7 17:13
 */

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BaseQuery extends Page implements Serializable {


}
