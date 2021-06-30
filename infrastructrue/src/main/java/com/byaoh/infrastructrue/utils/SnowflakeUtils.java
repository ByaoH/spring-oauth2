package com.byaoh.infrastructrue.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.system.HostInfo;
import cn.hutool.system.SystemUtil;

/**
 * SnowflakeUtils
 *
 * @author luliangyu
 * @date 2021-06-23 18:58
 */
public class SnowflakeUtils {
	private SnowflakeUtils() {
	}

	private volatile static Snowflake snowflake = null;

	private static Snowflake snowflake() {
		if (snowflake == null) {
			HostInfo hostInfo = SystemUtil.getHostInfo();
			String address = hostInfo.getAddress();
			String[] split = address.split("\\.");
			snowflake = IdUtil.createSnowflake(Long.parseLong(split[split.length - 2]) % 30, Long.parseLong(split[split.length - 1]) % 30);
		}
		return snowflake;
	}

	public static long id() {
		return snowflake().nextId();
	}
}
