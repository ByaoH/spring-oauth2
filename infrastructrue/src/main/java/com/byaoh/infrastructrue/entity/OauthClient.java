package com.byaoh.infrastructrue.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OauthClient
 *
 * @author luliangyu
 * @date 2021-06-30 11:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "oauth_client")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OauthClient extends BaseEntity {
	/**
	 * client-id
	 */
	@Column(name = "client_id", nullable = false, unique = true)
	private String clientId;

	/**
	 * client-secret
	 */
	@Column(name = "client_secret", nullable = false)
	private String clientSecret;

	/**
	 * 申请的权限范围
	 */
	@Column(name = "scope", nullable = false)
	private String scope;

	/**
	 * 四种授权模式 多个使用逗号隔开
	 * <ul>
	 *     <li>- Authorization Code（授权码模式）：正宗的OAuth2的授权模式，客户端先将用户导向认证服务器，登录后获取授权码，然后进行授权，最后根据授权码获取访问令牌；</li>
	 *     <li>- Implicit（简化模式）：和授权码模式相比，取消了获取授权码的过程，直接获取访问令牌；</li>
	 *     <li>- Resource Owner Password Credentials（密码模式）：客户端直接向用户获取用户名和密码，之后向认证服务器获取访问令牌；</li>
	 *     <li>- Client Credentials（客户端模式）：客户端直接通过客户端认证（比如client_id和client_secret）从认证服务器获取访问令牌。</li>
	 * </ul>
	 */
	@Column(name = "authorized_grant_type", nullable = false)
	private String authorizedGrantType;

	/**
	 * 授权成功后跳转
	 */
	@Column(name = "redirect_uri", nullable = false)
	private String redirectUri;

	/**
	 * token 有效期
	 */
	@Column(name = "access_token_validity_second", nullable = false)
	private Integer accessTokenValiditySecond;

	/**
	 * token 刷新间隔
	 */
	@Column(name = "refresh_token_validity_seconds", nullable = false)
	private Integer refreshTokenValiditySeconds;

	/**
	 * 是否刷新令牌
	 */
	@Column(name = "auto_approve", nullable = false)
	private Integer autoApprove;
}
