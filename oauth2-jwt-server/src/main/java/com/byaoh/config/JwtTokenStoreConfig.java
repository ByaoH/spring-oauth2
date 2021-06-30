package com.byaoh.config;

import com.byaoh.constant.JwtInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 使用Jwt存储token的配置
 *
 * @author luliangyu
 * @date 2021-06-30 09:41
 */
@Configuration
public class JwtTokenStoreConfig {
	@Primary
	@Bean(name = "myJwtTokenStore")
	public TokenStore jwtTokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		//配置JWT使用的秘钥
		accessTokenConverter.setSigningKey(JwtInfo.KEY);
		return accessTokenConverter;
	}
}
