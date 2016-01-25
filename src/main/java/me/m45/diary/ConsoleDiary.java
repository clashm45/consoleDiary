package me.m45.diary;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleDiary {

	public static void main(String[] args) throws IOException {
		String fileName = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE)+".md";
		String todate = "["+LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"]";
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter writer = Files.newBufferedWriter(
						Paths.get("build", fileName), UTF_8, CREATE) ) {
			//今日の日付を記述
			System.out.println(todate);
			writer.write(todate);
			writer.newLine();

			while(true) {
				String str = reader.readLine();
				if("eol".equals(str)) {
					break;
				}
				writer.write(str);
				writer.newLine();
			}
		}
	}
}
