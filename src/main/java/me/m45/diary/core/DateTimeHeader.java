package me.m45.diary.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import me.m45.diary.util.DateUtils;

/**
 * 日付のヘッダ
 * @author clashm45
 *
 */
public class DateTimeHeader implements Header {

	private LocalDateTime date;
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public DateTimeHeader() {
		this.date = LocalDateTime.now();
	}
	/**
	 * format '2016-12-03'
	 * @param day
	 */
	public DateTimeHeader(String day) {
		this.date = DateUtils.withDay(day);
	}

	@Override
	public String generateHeader() {
		return "["+this.date.format(this.format)+"]";
	}

}
