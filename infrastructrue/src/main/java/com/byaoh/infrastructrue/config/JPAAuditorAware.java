package com.byaoh.infrastructrue.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * JPAAuditorAware
 *
 * @author luliangyu
 * @date 2021-06-24 09:19
 */
@Component
public class JPAAuditorAware implements AuditorAware<Long> {
	@Override
	public Optional<Long> getCurrentAuditor() {
		return Optional.of(userId());
	}

	private Long userId() {
		return 1L;
	}
}
