package com.local.admin.controller;

import com.local.admin.response.RestResponse;
import com.local.admin.service.UserService;
import com.local.admin.service.constant.PropConfig;
import com.local.admin.service.vo.sysuser.AddSysUserReqVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Api(value = "用户")
@RequestMapping(value = "/v1/mgt/sys-user")
public class UserController {

    @Autowired
    PropConfig propConfig;

    @Autowired
    private UserService sysUserService;

    @ApiOperation(value = "新增用户", httpMethod = "POST")
    @RequestMapping(value = "/add-sys-user")
    public RestResponse<Void> addSysUser(@RequestBody AddSysUserReqVo addSysUserReqVo, HttpServletRequest request) throws InterruptedException {
        HttpSession session = request.getSession();
        System.out.println(propConfig);
        sysUserService.addSysUser(addSysUserReqVo);
        return RestResponse.ok();
    }

}
