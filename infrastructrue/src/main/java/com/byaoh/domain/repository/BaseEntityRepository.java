package com.byaoh.domain.repository;

/**
 * BaseEntityRepository
 *
 * @author luliangyu
 * @date 2021-06-24 09:32
 */
public interface BaseEntityRepository<Entity> {

	/**
	 * 根据id查询单个
	 *
	 * @param id id
	 * @return entity
	 */
	Entity getById(Long id);

	/**
	 * 保存单条数据
	 *
	 * @param add 新增数据
	 * @return 修改的行数
	 */
	int add(Entity add);

	/**
	 * 删除单条数据
	 *
	 * @param id id
	 * @return 修改的行数
	 */
	int deleteById(Long id);

	/**
	 * 根据id修改单条数据
	 *
	 * @param update 更新对象
	 * @return 修改的行数
	 */
	int updateById(Entity update);
}
