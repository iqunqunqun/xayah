package com.ivan.xayah.service.impl;

import com.ivan.xayah.entity.User;
import com.ivan.xayah.mapper.UserMapper;
import com.ivan.xayah.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ivan
 * @since 2021-03-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
