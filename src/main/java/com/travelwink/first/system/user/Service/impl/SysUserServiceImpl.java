package com.travelwink.first.system.user.Service.impl;

import com.travelwink.first.common.paginaton.PageInfo;
import com.travelwink.first.common.paginaton.Paging;
import com.travelwink.first.system.user.Service.SysUserService;
import com.travelwink.first.system.user.entity.SysUser;
import com.travelwink.first.system.user.mapper.SysUserMapper;
import com.travelwink.first.system.user.param.SysUserPageParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chris
 */

@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Paging<SysUser> getPageList(SysUserPageParam sysUserPageParam) {
        PageInfo<SysUser> page = new PageInfo<>(sysUserPageParam);
        PageInfo<SysUser> userPageInfo = sysUserMapper.selectPageList(page, sysUserPageParam);
        return new Paging<>(userPageInfo);
    }
}
