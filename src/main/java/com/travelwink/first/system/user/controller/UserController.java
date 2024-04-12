package com.travelwink.first.system.user.controller;

import com.travelwink.first.common.api.ApiResp;
import com.travelwink.first.common.api.ApiResult;
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

import java.util.List;

/**
 * @author chris
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
@Tag(name = "System - User")
public class UserController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private MdSparePartService mdSparePartService;

    @PostMapping("/getPageList")
    public ApiResp<Paging<SysUser>> getPageList(@RequestBody SysUserPageParam sysUserPageParam) {
        Paging<SysUser> userPaging = userService.getPageList(sysUserPageParam);
        return ApiResp.ok(userPaging);
    }

    @PostMapping("/getUserInfo")
    private ApiResult<List<PubC3dItemRelVo>> getSubPart(@RequestBody SubSparePartParam param) throws Exception {
        List<PubC3dItemRelVo> relVoList = mdSparePartService.getSubPart(param);
        return ApiResult.ok(relVoList);
    }
}
