package com.ivan.xayah.controller;


import com.ivan.xayah.dto.SysDictDTO;
import com.ivan.xayah.entity.SysDict;
import com.ivan.xayah.service.ISysDictService;
import com.ivan.xayah.tool.api.R;
import com.ivan.xayah.tool.api.annotation.CustomResponse;
import com.ivan.xayah.tool.init.dict.DictItem;
import com.ivan.xayah.tool.init.dict.DictUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 新增字典
     */
    @PostMapping
    public R submit(@RequestBody SysDictDTO dictDTO) {
        return R.data(sysDictService.submit(dictDTO));
    }

    /**
     * 获取字典值
     */
    @CustomResponse
    @GetMapping
    public DictItem getDictByCode() {
        DictItem dictItem = DictUtil.getItemByCategoryAndDict("status", "close");
        return dictItem;
    }
}
