package com.byaoh.controller;

import com.alibaba.fastjson.JSONObject;
import com.byaoh.constant.JwtInfo;
import com.byaoh.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * UserController
 *
 * @author luliangyu
 * @date 2021-06-29 17:33
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@GetMapping
	public JSONObject get(HttpServletRequest request) {
		String header = request.getHeader(JwtInfo.TOKEN_REQUEST_HEADER);
		String token = header.replace(JwtInfo.TOKEN_HEADER, "");
		JSONObject data = new JSONObject();
		data.put("code", 200);
		data.put("message", "操作成功");
		data.put("data", JwtUtil.parser(token));
		return data;
	}
}
