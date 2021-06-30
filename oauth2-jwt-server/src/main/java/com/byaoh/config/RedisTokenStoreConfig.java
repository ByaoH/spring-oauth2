package com.byaoh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * RedisTokenStoreConfig
 *
 * @author luliangyu
 * @date 2021-06-30 09:32
 */
@Configuration
public class RedisTokenStoreConfig {

	private final RedisConnectionFactory redisConnectionFactory;

	public RedisTokenStoreConfig(RedisConnectionFactory redisConnectionFactory) {
		this.redisConnectionFactory = redisConnectionFactory;
	}

	@Bean
	public TokenStore redisTokenStore() {
		return new RedisTokenStore(redisConnectionFactory);
	}
}
