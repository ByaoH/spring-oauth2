package com.byaoh.infrastructrue.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author luliangyu
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "base_user")
public class BaseUser extends BaseEntity {

	/**
	 * 用户名
	 */
	@Column(name = "username", unique = true, nullable = false)
	private String username;

	/**
	 * 密码
	 */
	@Column(name = "password", nullable = false)
	private String password;

	/**
	 * 启用状态
	 */
	@Column(name = "status")
	private Integer status = 1;

	/**
	 * 关联部门表
	 * 1、关系维护端，负责多对多关系的绑定和解除
	 * 2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
	 * 3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Department)
	 * 4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
	 * 即表名为user_department
	 * 关联到主表的外键名：主表名+下划线+主表中的主键列名,即user_id,这里使用referencedColumnName指定
	 * 关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,department_id
	 * 主表就是关系维护端对应的表，从表就是关系被维护端对应的表
	 */
	@ManyToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinTable(
		name = "base_user_department",
		joinColumns = @JoinColumn(
			name = "user_id",
			referencedColumnName = "id"
		),
		inverseJoinColumns = @JoinColumn(
			name = "department_id",
			referencedColumnName = "id")
	)
	private Collection<BaseDepartment> departmentList;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}

		BaseUser user = (BaseUser) o;

		if (!username.equals(user.username)) {
			return false;
		}
		if (!password.equals(user.password)) {
			return false;
		}
		return status.equals(user.status);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + username.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + status.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "BaseUser{" +
			"username='" + username + '\'' +
			", password='" + password + '\'' +
			", status=" + status +
			'}';
	}
}
