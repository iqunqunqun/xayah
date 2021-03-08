package com.ivan.xayah.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ivan.xayah.dto.SysDictDTO;
import com.ivan.xayah.entity.SysDict;
import com.ivan.xayah.mapper.SysDictMapper;
import com.ivan.xayah.service.ISysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ivan.xayah.tool.constant.CommonConstant;
import com.ivan.xayah.tool.init.dict.DictItem;
import com.ivan.xayah.tool.init.dict.DictUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统字典表 服务实现类
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
@Service
@DS("upms")
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {

    @Override
    public boolean submit(SysDictDTO dictDTO) {
        return save(SysDictDTO.convert(dictDTO));
    }

    @Override
    public void init() {
        DictUtil.dictCache = baseMapper.initDict();
    }
}
