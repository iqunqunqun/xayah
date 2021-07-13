package com.ivan.xayah.controller;


import com.ivan.xayah.entity.SysLog;
import com.ivan.xayah.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author ivan
 * @since 2021-03-10
 */
@RestController
@RequestMapping("/sys-log")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;


    @PostMapping()
    public Boolean save(@RequestBody SysLog sysLog) {
        return sysLogService.save(sysLog);
    }

}
