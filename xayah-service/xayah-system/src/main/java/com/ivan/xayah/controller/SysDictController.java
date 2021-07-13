package com.ivan.xayah.controller;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ivan.xayah.annotation.SysLog;
import com.ivan.xayah.dto.SysDictDTO;
import com.ivan.xayah.entity.SysDict;
import com.ivan.xayah.query.DictQuery;
import com.ivan.xayah.service.ISysDictService;
import com.ivan.xayah.tool.api.R;
import com.ivan.xayah.tool.api.annotation.CustomResponse;
import com.ivan.xayah.tool.init.dict.DictItem;
import com.ivan.xayah.tool.init.dict.DictUtil;
import com.ivan.xayah.tool.redis.RedisUtil;
import com.ivan.xayah.vo.DictVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统字典表 前端控制器
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/sys-dict")
public class SysDictController {

    @Autowired
    private ISysDictService sysDictService;

    @Autowired
    private DictUtil dictUtil;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 新增字典
     */
    @SysLog("新增字典")
    @PostMapping
    public R submit(@RequestBody SysDictDTO dictDTO) {
        return R.data(sysDictService.submit(dictDTO));
    }

    /**
     * 删除字典值
     */
    @DeleteMapping
    public R delete(SysDict sysDict) {
        boolean remove = sysDictService.removeById(sysDict.getDictId());
        redisUtil.hdel(sysDict.getCategoryCode(), sysDict.getDictCode());
        return R.data(remove);
    }

    /**
     * 字典列表
     */
    @CustomResponse
    @GetMapping("/page")
    public Page<DictVO> pageDict(DictQuery dictQuery) {
        return sysDictService.pageDict(dictQuery);
    }
}
