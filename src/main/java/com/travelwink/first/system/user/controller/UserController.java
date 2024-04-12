package com.travelwink.first.system.user.controller;

import com.travelwink.first.common.api.ApiResp;
import com.travelwink.first.common.api.ApiResult;
import com.travelwink.first.common.paginaton.Paging;
import com.travelwink.first.system.user.Service.SysUserService;
import com.travelwink.first.system.user.entity.SysUser;
import com.travelwink.first.system.user.param.SysUserPageParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chris
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
@Tag(name = "System management - User")
public class UserController {

    @Autowired
    private SysUserService userService;

    @PostMapping("/getPageList")
    @Operation(method = "POST", summary = "分页查询")
    public ApiResp<Paging<SysUser>> getPageList(@RequestBody SysUserPageParam sysUserPageParam) {
        Paging<SysUser> userPaging = userService.getPageList(sysUserPageParam);
        return ApiResp.ok(userPaging);
    }

    @GetMapping("/getDetails/{id}")
    @Operation(summary = "详情")
    private ApiResult<SysUser> getDetails(@PathVariable("id")  String id) {
        SysUser userVo = userService.getDetails(id);
        return ApiResult.ok(userVo);
    }
}
