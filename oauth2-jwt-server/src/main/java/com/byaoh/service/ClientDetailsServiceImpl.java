package com.byaoh.service;

import com.byaoh.infrastructrue.dao.OauthClientDao;
import com.byaoh.infrastructrue.entity.OauthClient;
import com.byaoh.model.Client;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 * ClientDetailsServiceImpl
 *
 * @author luliangyu
 * @date 2021-06-30 11:08
 */
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {
	private final OauthClientDao oauthClientDao;

	public ClientDetailsServiceImpl(OauthClientDao oauthClientDao) {
		this.oauthClientDao = oauthClientDao;
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		OauthClient one = oauthClientDao.findByClientId(clientId);
		if (one == null) {
			throw new ClientRegistrationException("clientId 有误");
		}
		return new Client(one);
	}
}
