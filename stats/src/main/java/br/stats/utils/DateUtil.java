package br.stats.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateUtil {
	public static LocalDateTime convertToLocalDateTime(Long timestamp) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.UTC);
	}
	
	public static Long converToTimeStamp(LocalDateTime localDateTime) {
		return localDateTime.toEpochSecond(ZoneOffset.UTC) * 1000;
	}
	
}
