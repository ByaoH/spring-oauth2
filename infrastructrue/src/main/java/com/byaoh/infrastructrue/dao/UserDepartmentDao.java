package com.byaoh.infrastructrue.dao;

import com.byaoh.infrastructrue.entity.BaseUserDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserDepartmentDao
 *
 * @author luliangyu
 * @date 2021-06-25 17:05
 */
@Repository
public interface UserDepartmentDao extends JpaRepository<BaseUserDepartment, Long> {
}
