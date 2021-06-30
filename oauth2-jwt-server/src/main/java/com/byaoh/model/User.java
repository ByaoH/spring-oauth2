package com.byaoh.model;

import com.byaoh.infrastructrue.entity.BaseUser;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * User
 *
 * @author luliangyu
 * @date 2021-06-29 17:24
 */
public class User extends BaseUser implements UserDetails {
	public User() {
	}

	public User(BaseUser user) {
		BeanUtils.copyProperties(user, this);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return getStatus() == 1;
	}
}
