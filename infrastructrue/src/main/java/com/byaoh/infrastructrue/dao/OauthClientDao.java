package com.byaoh.infrastructrue.dao;

import com.byaoh.infrastructrue.entity.OauthClient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OauthClientDao
 *
 * @author luliangyu
 * @date 2021-06-30 11:50
 */
public interface OauthClientDao extends JpaRepository<OauthClient, Long> {
	/**
	 * 根据 clientId 查找单个
	 *
	 * @param clientId client_id
	 * @return 不存在返回null
	 */
	OauthClient findByClientId(String clientId);
}
