package com.ivan.xayah.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ivan.xayah.dto.SysDictDTO;
import com.ivan.xayah.entity.SysDict;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
public interface ISysDictService extends IService<SysDict> {

    /**
     * 新增字典
     * @param dictDTO
     * @return
     */
    boolean submit(SysDictDTO dictDTO);

    /**
     * 字典初始化
     */
    void init();
}
