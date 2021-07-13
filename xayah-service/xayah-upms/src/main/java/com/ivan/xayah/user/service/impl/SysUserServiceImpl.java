package com.ivan.xayah.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ivan.xayah.entity.SysUser;
import com.ivan.xayah.user.mapper.SysUserMapper;
import com.ivan.xayah.query.SysUserQuery;
import com.ivan.xayah.user.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ivan.xayah.vo.SysUserVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public IPage<SysUserVO> pageUser(SysUserQuery userQuery) {
        return baseMapper.pageUser(userQuery);
    }
}
