package com.travelwink.first.system.user.Service;

import com.travelwink.first.common.paginaton.Paging;
import com.travelwink.first.system.user.entity.SysUser;
import com.travelwink.first.system.user.param.SysUserPageParam;

/**
 * @author chris
 */
public interface SysUserService {
    Paging<SysUser> getPageList(SysUserPageParam sysUserPageParam);

    SysUser getDetails(String id);
}
