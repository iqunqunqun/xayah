package com.ivan.xayah.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ivan.xayah.entity.SysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ivan.xayah.query.DictQuery;
import com.ivan.xayah.tool.init.dict.DictItem;
import com.ivan.xayah.vo.DictVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统字典表 Mapper 接口
 * </p>
 *
 * @author ivan
 * @since 2021-03-07
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 初始化字典到内存
     * @return
     */
    List<DictItem> initDict();

    /**
     * 分页查询字典值
     * @param dictQuery
     * @return
     */
    Page<DictVO> pageDict(@Param("dictQuery") DictQuery dictQuery);
}
