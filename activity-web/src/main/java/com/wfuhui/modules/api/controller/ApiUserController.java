package com.wfuhui.modules.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.R;
import com.wfuhui.modules.api.annotation.LoginUser;
import com.wfuhui.modules.base.entity.UserEntity;
import com.wfuhui.modules.base.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/user/")
@Api("用户接口")
public class ApiUserController {
	
	@Autowired
	private UserService userService;
	
    @PostMapping("update")
    @ApiOperation(value = "更新用户信息")
    public R update(@RequestBody UserEntity user){
    	userService.update(user);
        return R.ok();
    }
    
    @GetMapping("info")
    @ApiOperation(value = "获取用户信息")
    public R info(@LoginUser UserEntity user) {
    	return R.ok().put("user", user);
    }
}
