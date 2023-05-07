package com.travelwink.first.system.user.Service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travelwink.first.common.paginaton.PageInfo;
import com.travelwink.first.common.paginaton.Paging;
import com.travelwink.first.system.user.Service.SysUserService;
import com.travelwink.first.system.user.entity.SysUser;
import com.travelwink.first.system.user.mapper.SysUserMapper;
import com.travelwink.first.system.user.param.SysUserPageParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return null;
    }
}
