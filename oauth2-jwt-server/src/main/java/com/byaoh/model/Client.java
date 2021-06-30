package com.byaoh.model;

import com.byaoh.infrastructrue.entity.OauthClient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Client
 *
 * @author luliangyu
 * @date 2021-06-30 11:09
 */
public class Client implements ClientDetails {
	private OauthClient oauthClient;

	public Client(OauthClient oauthClient) {
		this();
		this.oauthClient = oauthClient;
	}

	public Client() {
	}

	@Override
	public String getClientId() {
		return oauthClient.getClientId();
	}

	@Override
	public Set<String> getResourceIds() {
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

	@Override
	public String getClientSecret() {
		return oauthClient.getClientSecret();
	}

	@Override
	public boolean isScoped() {
		return true;
	}

	@Override
	public Set<String> getScope() {
		return Arrays.stream(oauthClient.getScope().split(",")).collect(Collectors.toSet());
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return Arrays.stream(oauthClient.getAuthorizedGrantType().split(",")).collect(Collectors.toSet());
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return Arrays.stream(oauthClient.getRedirectUri().split(",")).collect(Collectors.toSet());
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return oauthClient.getAccessTokenValiditySecond();
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return oauthClient.getRefreshTokenValiditySeconds();
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return oauthClient.getAutoApprove() == 1;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}
}
