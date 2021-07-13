package com.ivan.xayah.user.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ivan.xayah.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ivan.xayah.query.SysUserQuery;
import com.ivan.xayah.vo.SysUserVO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
@DS("upms")
public interface ISysUserService extends IService<SysUser> {

    /**
     * 分页查询用户
     * @param userQuery
     * @return IPage<SysUser>
     */
    IPage<SysUserVO> pageUser(SysUserQuery userQuery);
}
