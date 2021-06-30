package com.byaoh.config;

import com.byaoh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * 认证服务器配置
 */
@Configuration
//开启oauth认证
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	/**
	 * 使用密码模式需要配置
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.authenticationManager(authenticationManager)
			.userDetailsService(userService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			//配置client_id
			.withClient("admin")
			//配置client-secret
			.secret(passwordEncoder.encode("admin123456"))
			//配置访问token的有效期
			.accessTokenValiditySeconds(3600)
			//配置刷新token的有效期
			.refreshTokenValiditySeconds(864000)
			//配置redirect_uri，用于授权成功后跳转
			.redirectUris("https://www.hao123.com")
			//配置申请的权限范围
			.scopes("all")
			//配置grant_type，表示授权类型
			.authorizedGrantTypes("authorization_code", "password");
//		访问
//		http://localhost:10000/oauth/authorize?response_type=code&client_id=admin&redirect_uri=https://www.hao123.com&scope=all&state=normal
	}
}