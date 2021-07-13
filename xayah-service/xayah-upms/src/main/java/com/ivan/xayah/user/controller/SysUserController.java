package com.ivan.xayah.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ivan.xayah.entity.SysUser;
import com.ivan.xayah.query.SysUserQuery;
import com.ivan.xayah.user.service.ISysUserService;
import com.ivan.xayah.tool.api.annotation.CustomResponse;
import com.ivan.xayah.tool.init.dict.DictItem;
import com.ivan.xayah.tool.init.dict.DictUtil;
import com.ivan.xayah.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private DictUtil dictUtil;

    /**
     * 获取用户列表
     */
    @GetMapping("/list")
    @CustomResponse
    public List<SysUser> listUser() {
        return userService.list();
    }

    /**
     * 分页获取用户列表
     */
    @GetMapping("/page")
    @CustomResponse
    public IPage<SysUserVO> pageUser(SysUserQuery userQuery) {
        return userService.pageUser(userQuery);
    }


    /**
     * 获取字典值
     */
    @CustomResponse
    @GetMapping
    public DictItem getDictByCode() {
        DictItem dictItem = dictUtil.getItemByCategoryAndDict("test", "test");
        return dictItem;
    }
}
