package com.byaoh.infrastructrue.dao;

import com.byaoh.infrastructrue.entity.BaseDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * DepartmentDao
 *
 * @author luliangyu
 * @date 2021-06-25 16:44
 */
public interface DepartmentDao extends JpaRepository<BaseDepartment, Long> {
	/**
	 * 根据 层级查找
	 *
	 * @param levels 层级
	 * @return 查找的列表
	 */
	List<BaseDepartment> findByLevels(Integer levels);
}
