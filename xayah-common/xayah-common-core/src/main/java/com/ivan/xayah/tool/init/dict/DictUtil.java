package com.ivan.xayah.tool.init.dict;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.ivan.xayah.tool.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author ivan
 * @className DictUtil
 * @since 2021/3/7 21:50
 */

@Component
public class DictUtil {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 通过分类编码和字典编码获取字典值
     * @param categoryCode
     * @param dictCode
     * @return
     */
    public DictItem getItemByCategoryAndDict(String categoryCode, String dictCode) {

        if (StrUtil.isBlankIfStr(categoryCode) || StrUtil.isBlankIfStr(dictCode)) {
            return null;
        }

        return (DictItem) redisUtil.hget(categoryCode, dictCode);
    }

    /**
     * 通过分类编码和字典编码获取字典值
     * @param categoryCode
     * @param dictCode
     * @return
     */
    public Integer getValueByCategoryAndDict(String categoryCode, String dictCode) {

        if (StrUtil.isBlankIfStr(categoryCode) || StrUtil.isBlankIfStr(dictCode)) {
            return -1;
        }
        DictItem dictItem = (DictItem) redisUtil.hget(categoryCode, dictCode);

        if (ObjectUtil.isNotNull(dictItem)) {
            return dictItem.getDictValue();
        }

        return -1;
    }

}
