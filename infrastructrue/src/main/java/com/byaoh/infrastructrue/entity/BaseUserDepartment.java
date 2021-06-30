package com.byaoh.infrastructrue.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 用户部门多对多关联表
 *
 * @author luliangyu
 * @date 2021-06-25 16:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "base_user_department", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "department_id"}))
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseUserDepartment extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private BaseUser user;

	@OneToOne
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private BaseDepartment department;
}
