package com.byaoh.service;

import com.byaoh.infrastructrue.dao.UserDao;
import com.byaoh.infrastructrue.entity.BaseUser;
import com.byaoh.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * com.byaoh.service.UserService
 *
 * @author luliangyu
 * @date 2021-06-29 17:20
 */
@Slf4j
@Service
public class UserService implements UserDetailsService {
	private final UserDao userDao;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		BaseUser user = userDao.findByUsername(s);
		System.err.println(passwordEncoder.encode("123456"));
		if (user == null) {
			throw new UsernameNotFoundException("用户名或密码错误");
		}
		return new User(user);
	}
}
