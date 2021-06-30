package com.byaoh.utils;

import com.byaoh.constant.JwtInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.nio.charset.StandardCharsets;

/**
 * JwtUtil
 *
 * @author luliangyu
 * @date 2021-06-30 10:00
 */
public class JwtUtil {
	private JwtUtil() {
	}

	public static Object parser(String token) {
		Claims body = Jwts.parser()
			.setSigningKey(JwtInfo.KEY.getBytes(StandardCharsets.UTF_8))
			.parseClaimsJws(token)
			.getBody();
		return body;
	}
}
