package com.travelwink.first.system.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travelwink.first.common.paginaton.PageInfo;
import com.travelwink.first.system.user.Service.SysUserService;
import com.travelwink.first.system.user.entity.SysUser;
import com.travelwink.first.system.user.param.SysUserPageParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chris
 */
@Slf4j
@RestController
@RequestMapping("/sys/user")
@Tag(name = "系统管理-用户")
public class UserController {

    @Autowired
    private SysUserService userService;

    @PostMapping("/getPageList")
    public PageInfo<SysUser> getUserPageList(SysUserPageParam sysUserPageParam) {
        return userService.getPageList(sysUserPageParam);
    }
}
