package me.m45.diary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ConsoleDiary {

	public static void main(String[] args) throws IOException {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter writer = Files.newBufferedWriter(
						Paths.get("build", "firstdialy.md"),
						StandardCharsets.UTF_8,
						StandardOpenOption.CREATE) ) {
			writer.write(reader.readLine());
		}
	}



}
