package com.ivan.xayah.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ivan.xayah.entity.SysUser;
import com.ivan.xayah.query.SysUserQuery;
import com.ivan.xayah.vo.SysUserVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 分页查询用户
     * @param userQuery
     * @return
     */
    IPage<SysUserVO> pageUser(@Param("userQuery") SysUserQuery userQuery);
}
