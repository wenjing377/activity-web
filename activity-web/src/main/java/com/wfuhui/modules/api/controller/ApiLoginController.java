package com.wfuhui.modules.api.controller;

import com.wfuhui.common.utils.R;
import com.wfuhui.modules.api.annotation.AuthIgnore;
import com.wfuhui.modules.api.service.TokenService;
import com.wfuhui.modules.base.entity.UserEntity;
import com.wfuhui.modules.base.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * 登录相关

 */
@RestController
@RequestMapping("/api")
public class ApiLoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private TokenService tokenService;

	/**
	 * 登录
	 */
	@AuthIgnore
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(String loginName, String password)throws IOException {

		//用户信息
		UserEntity user = userService.queryByLoginName(loginName);

		//账号不存在、密码错误
		if(user == null || !user.getPassword().equals(password)) {
			return R.error("账号或密码不正确");
		}

		//生成token，并保存到数据库
		Map<String, Object> map = tokenService.createToken(user.getId());
		map.put("user", user);
		return R.ok(map);
	}

	/**
	 * 登录
	 */
	@AuthIgnore
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Object> register(String loginName, String password, String mobile,String email,String gender , String realName, String address, String idCard, String userNo, String schoolName, String className)throws IOException {
		UserEntity user = new UserEntity();
		user.setLoginName(loginName);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setGender(gender);
		user.setRealName(realName);
		user.setAddress(address);
		user.setUserNo(userNo);
		user.setSchoolName(schoolName);
		user.setClassName(className);
		user.setIdCard(idCard);
		user.setCreateTime(new Date());
		userService.save(user);
		return R.ok();
	}

}
