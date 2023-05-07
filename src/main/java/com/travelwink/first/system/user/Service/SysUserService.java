package com.travelwink.first.system.user.Service;

import com.travelwink.first.common.paginaton.PageInfo;
import com.travelwink.first.system.user.entity.SysUser;
import com.travelwink.first.system.user.param.SysUserPageParam;

/**
 * @author chris
 */
public interface SysUserService {
    PageInfo<SysUser> getPageList(SysUserPageParam sysUserPageParam);
}
