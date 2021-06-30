package com.byaoh.domain.repository;

import com.byaoh.domain.user.UserQueryModel;
import com.byaoh.domain.vo.UserVO;
import com.byaoh.infrastructrue.entity.BaseUser;

import java.util.List;

/**
 * UserRepository
 *
 * @author luliangyu
 * @date 2021-06-24 09:35
 */
public interface UserRepository extends BaseEntityRepository<BaseUser> {
	/**
	 * 条件查询
	 *
	 * @param queryModel
	 * @return
	 */
	List<UserVO> findByCondition(UserQueryModel queryModel);
}
