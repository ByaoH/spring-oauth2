package com.byaoh.domain.user;

import lombok.Data;

import java.io.Serializable;

/**
 * UserQueryModel
 *
 * @author luliangyu
 * @date 2021-06-24 10:36
 */
@Data
public class UserQueryModel implements Serializable {
	private Long id;

	private String username;

	private Integer status;

}
