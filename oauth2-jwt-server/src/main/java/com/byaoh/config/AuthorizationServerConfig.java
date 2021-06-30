package com.byaoh.config;

import com.byaoh.component.JwtTokenEnhancer;
import com.byaoh.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * 认证服务器配置
 */
@Configuration
//开启oauth认证
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	private final UserService userService;

	private final TokenStore tokenStore;

	private final JwtAccessTokenConverter jwtAccessTokenConverter;

	private final JwtTokenEnhancer jwtTokenEnhancer;

	private final DataSource datasource;

	public AuthorizationServerConfig(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, UserService userService, @Qualifier("redisTokenStore") TokenStore tokenStore, JwtAccessTokenConverter jwtAccessTokenConverter, JwtTokenEnhancer jwtTokenEnhancer, DataSource datasource) {
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.userService = userService;
		this.tokenStore = tokenStore;
		this.jwtAccessTokenConverter = jwtAccessTokenConverter;
		this.jwtTokenEnhancer = jwtTokenEnhancer;
		this.datasource = datasource;
	}

	/**
	 * 使用密码模式需要配置
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		List<TokenEnhancer> delegates = new ArrayList<>();
		//配置JWT的内容增强器
		delegates.add(jwtTokenEnhancer);
		delegates.add(jwtAccessTokenConverter);
		enhancerChain.setTokenEnhancers(delegates);

		endpoints.authenticationManager(authenticationManager)
			.userDetailsService(userService)
			//配置令牌存储策略
			.tokenStore(tokenStore)
			.accessTokenConverter(jwtAccessTokenConverter)
//			设置内容增强器
			.tokenEnhancer(enhancerChain)
		;
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.jdbc(datasource);
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
			.autoApprove(true)
			//配置申请的权限范围
			.scopes("all")
			//配置grant_type，表示授权类型
			.authorizedGrantTypes("authorization_code", "password")
		;
//		访问
//		http://localhost:10000/oauth/authorize?response_type=code&client_id=admin&redirect_uri=https://www.hao123.com&scope=all&state=normal
	}
}