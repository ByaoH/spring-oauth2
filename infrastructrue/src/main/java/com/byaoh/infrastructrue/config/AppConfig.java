package com.byaoh.infrastructrue.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig
 *
 * @author luliangyu
 * @date 2021-06-23 18:48
 */
@Configuration
public class AppConfig {

	@Bean
	public Snowflake snowflake() {
		return IdUtil.createSnowflake(1, 1);
	}
}
