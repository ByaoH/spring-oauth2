package com.byaoh.component;

import com.byaoh.model.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Jwt内容增强器
 */
@Component
public class JwtTokenEnhancer implements TokenEnhancer {
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<>();
		User user = (User) authentication.getUserAuthentication().getPrincipal();
//		info.put("enhance", "enhance info");
//		自定义token信息
		info.put("userId", user.getId());
		info.put("username", user.getUsername());
		info.put("userCreateTime", user.getCreateTime());
//		info.put("userDepartments", user.getDepartmentList());
		info.put("authorities", user.getAuthorities());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
}
