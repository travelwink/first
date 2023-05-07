package com.travelwink.first.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travelwink.first.common.paginaton.PageInfo;
import com.travelwink.first.system.user.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chris
 */
@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    @Select("SELECT * FROM sys_user")
    PageInfo<SysUser> selectPageList(IPage<SysUser> page);
}
