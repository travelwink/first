package com.travelwink.first.system.user.controller;

import com.travelwink.first.common.api.ApiResp;
import com.travelwink.first.common.paginaton.Paging;
import com.travelwink.first.system.user.Service.SysUserService;
import com.travelwink.first.system.user.entity.SysUser;
import com.travelwink.first.system.user.param.SysUserPageParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chris
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
@Tag(name = "系统管理-用户")
public class UserController {

    @Autowired
    private SysUserService userService;

    @PostMapping("/getPageList")
    public ApiResp<Paging<SysUser>> getPageList(@RequestBody SysUserPageParam sysUserPageParam) {
        Paging<SysUser> userPaging = userService.getPageList(sysUserPageParam);
        return ApiResp.ok(userPaging);
    }
}
