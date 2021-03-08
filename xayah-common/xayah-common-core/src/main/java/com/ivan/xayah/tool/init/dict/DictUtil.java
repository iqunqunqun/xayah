package com.ivan.xayah.tool.init.dict;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author ivan
 * @className DictUtil
 * @since 2021/3/7 21:50
 */
public class DictUtil {

    public static List<DictItem> dictCache = new ArrayList<>();


    /**
     * 通过分类编码和字典编码获取字典值
     * @param categoryCode
     * @param dictCode
     * @return
     */
    public static DictItem getItemByCategoryAndDict(String categoryCode, String dictCode) {

        if (StrUtil.isBlankIfStr(categoryCode) || StrUtil.isBlankIfStr(dictCode)) {
            return null;
        }

        Optional<DictItem> first = dictCache.stream()
                .filter(dictItem -> dictItem.getCategoryCode().equals(categoryCode)
                        && dictItem.getDictCode().equals(dictCode))
                .findFirst();

        return first.orElse(null);
    }

}
