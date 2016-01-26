package me.m45.diary.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import me.m45.diary.util.DateUtils;

/**
 * ファイル名に日付をつける
 * @author clashm45
 *
 */
public class DateTimeFileName implements FileName {

	private LocalDateTime date;
	private DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE;

	public DateTimeFileName() {
		this.date = LocalDateTime.now();
	}
	/**
	 * format '2016-12-03'
	 * @param day
	 */
	public DateTimeFileName(String day) {
		this.date = DateUtils.withDay(day);
	}
	/*
	 * (非 Javadoc)
	 * @see me.m45.diary.core.FileName#generateFileName()
	 */
	@Override
	public String generateFileName() {
		return this.date.format(this.format)+".md";
	}
}
