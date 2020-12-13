package com.th.controller;

import com.alibaba.fastjson.JSON;
import com.th.constant.SystemConstant;
import com.th.entity.R;
import com.th.entity.TAdmin;
import com.th.interceptor.SysInterceptor;
import com.th.service.TAdminService;
import com.th.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/tadmin")
public class TAdminController extends BaseController<TAdmin>{

	//日志对象
	private final static Logger logger= LoggerFactory.getLogger(SysInterceptor.class);

	@Autowired
	private TAdminService tAdminService;

    @RequestMapping("/login")
	//@GetMapping("/login")
	//@RequestMapping可以接收Get和Post请求  @GetMapping可以接收Get请求  @PostMapping可以接收Post请求
	@ResponseBody
	//@RequestBody 获取到异步axios从页面携带过来的JSON对象
	public R login(TAdmin tAdmin){
		try {
			TAdmin admin = tAdminService.findObjectByPramas(tAdmin);
			if(admin!=null){
				//把token返回给客户端-->客户端保存到cookie-->客户端每次请求附带cookie参数
				//SystemConstant.JWT_TTL token有效时间为1小时
				String JWT = JwtUtils.createJWT("1", JSON.toJSONString(admin), SystemConstant.JWT_TTL);
				System.out.println(JWT);
				return R.ok(JWT);
			}else{
				return R.error("用户名或者密码有误！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			R.error("服务器异常！");
		}

		return null;
	}

	// 刷新用户token
	@GetMapping(value = "/refreshToken")
	@ResponseBody
	public R refreshToken(HttpServletRequest request){
		Claims claims = JwtUtils.validateJWT(request.getHeader("token")).getClaims();
		String JWT = JwtUtils.createJWT(claims.getId(),claims.getSubject(), SystemConstant.JWT_TTL);
		logger.info("新token"+JWT);
		return R.ok(JWT);
	}



















}
