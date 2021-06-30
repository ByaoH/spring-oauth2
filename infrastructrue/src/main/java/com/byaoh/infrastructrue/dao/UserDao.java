package com.byaoh.infrastructrue.dao;

import com.byaoh.infrastructrue.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BaseR
 *
 * @author luliangyu
 * @date 2021-06-23 17:21
 */
@Repository
public interface UserDao extends JpaRepository<BaseUser, Integer> {
	/**
	 * 根据用户名查询
	 *
	 * @param username
	 * @return
	 */
	BaseUser findByUsername(String username);
}
