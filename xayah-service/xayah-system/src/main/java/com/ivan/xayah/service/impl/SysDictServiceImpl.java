package com.ivan.xayah.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ivan.xayah.dto.SysDictDTO;
import com.ivan.xayah.entity.SysDict;
import com.ivan.xayah.mapper.SysDictMapper;
import com.ivan.xayah.query.DictQuery;
import com.ivan.xayah.service.ISysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ivan.xayah.tool.init.dict.DictItem;
import com.ivan.xayah.tool.redis.RedisUtil;
import com.ivan.xayah.vo.DictVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统字典表 服务实现类
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
@Slf4j
@Service
@DS("upms")
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean submit(SysDictDTO dictDTO) {
        SysDict sysDict = SysDictDTO.convert(dictDTO);
        boolean save = save(sysDict);
        boolean hset = redisUtil.hset(sysDict.getCategoryCode(), sysDict.getDictCode(), SysDict.convert2DictItem(sysDict));

        return save && hset;
    }

    @Override
    public void init() {
        List<DictItem> dictItemList = baseMapper.initDict();
        if (CollectionUtil.isEmpty(dictItemList)) {
            log.info("=========暂无字典需要初始化=========");
            return;
        }

        ConcurrentMap<String, List<DictItem>> dictMap =
                dictItemList.stream().collect(Collectors.groupingByConcurrent(DictItem::getCategoryCode));

        dictMap.forEach((category, dictItems) -> {
            dictItems.forEach(dictItem -> {
                redisUtil.hset(category, dictItem.getDictCode(), dictItem);
            });
        });

        log.info("加载字典项共计-{}", dictItemList.size());
    }

    @Override
    public Page<DictVO> pageDict(DictQuery dictQuery) {
        return baseMapper.pageDict(dictQuery);
    }

}
