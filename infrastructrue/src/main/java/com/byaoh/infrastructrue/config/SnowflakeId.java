package com.byaoh.infrastructrue.config;

import com.byaoh.infrastructrue.utils.SnowflakeUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * Id
 *
 * @author luliangyu
 * @date 2021-06-23 18:32
 */
public class SnowflakeId implements IdentifierGenerator {

	public SnowflakeId() {
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		return SnowflakeUtils.id();
	}
}
