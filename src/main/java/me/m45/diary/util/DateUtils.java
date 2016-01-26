package me.m45.diary.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateUtils {

	/**
	 * '2016-01-01 現在時刻'のLocalDateTimeを生成する。
	 * @param day
	 * @return '$day 現在時刻'
	 */
	public static LocalDateTime withDay(String day) {
		return LocalDateTime.now().with(LocalDate.parse(day));
	}

}
