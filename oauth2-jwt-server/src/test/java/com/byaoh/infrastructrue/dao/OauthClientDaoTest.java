package com.byaoh.infrastructrue.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class OauthClientDaoTest {
	@Autowired
	private OauthClientDao dao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void findByClientId() {
//		OauthClient entity = new OauthClient();
//		entity.setClientId("admin");
//		entity.setClientSecret(passwordEncoder.encode("123456"));
//		entity.setScope("all");
//		entity.setAuthorizedGrantType("password,authorization_code");
//		entity.setRedirectUri("https://www.hao123.com");
//		entity.setAccessTokenValiditySecond(3600);
//		entity.setRefreshTokenValiditySeconds(864000);
//		entity.setAutoApprove(1);
//		dao.save(entity);
	}
}