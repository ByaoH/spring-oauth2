package com.byaoh.infrastructrue.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

/**
 * 部门实体类
 *
 * @author luliangyu
 * @date 2021-06-25 16:30
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "base_department")
@ToString(callSuper = true)
public class BaseDepartment extends BaseEntity {

	/**
	 * 部门名
	 */
	@Column(name = "name", nullable = false)
	private String name;

	/**
	 * 上级部门id
	 */
	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "superior", referencedColumnName = "id")
	private BaseDepartment superior;
	/**
	 * 所属层级
	 */
	@Column(name = "levels", nullable = false)
	private Integer levels = 1;

	/**
	 * 子部门集合
	 */
//    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "superior")
//    private Collection<BaseDepartment> children;

	/**
	 * 部门下用户集合
	 */
	@ManyToMany(mappedBy = "departmentList", fetch = FetchType.EAGER)
	private Collection<BaseUser> userList;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		BaseDepartment that = (BaseDepartment) o;

		if (!name.equals(that.name)) return false;
		if (!superior.equals(that.superior)) return false;
		return levels.equals(that.levels);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + name.hashCode();
		result = 31 * result + superior.hashCode();
		result = 31 * result + levels.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "BaseDepartment{" +
			"name='" + name + '\'' +
			", superior=" + superior +
			", levels=" + levels +
			'}';
	}
}
