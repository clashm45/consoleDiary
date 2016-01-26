package me.m45.diary;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import me.m45.diary.core.DateTimeFileName;
import me.m45.diary.core.DateTimeHeader;
import me.m45.diary.core.FileName;
import me.m45.diary.core.Header;

public class ConsoleDiary {

	private FileName fileName;
	private Header header;

	public static void main(String[] args) throws IOException {
		ConsoleDiary cd = build(args);
		cd.writeDiary();
	}
	private ConsoleDiary() {
		this.fileName = new DateTimeFileName();
		this.header = new DateTimeHeader();
	}

	public static ConsoleDiary build(String[] args) {
		final Option date = new Option("d", true, "日付を指定");

		ConsoleDiary cd = new ConsoleDiary();
		CommandLineParser parser = new DefaultParser();
		try {
			Options options = new Options();
			options.addOption(date);

			CommandLine cmd = parser.parse(options, args);
			if(cmd.hasOption("d")) {
				String dval = cmd.getOptionValue("d");
				cd.fileName = new DateTimeFileName(dval);
				cd.header = new DateTimeHeader(dval);
			}

		} catch(ParseException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getLocalizedMessage());
		}
		return cd;
	}

	public void writeDiary() throws IOException {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter writer = Files.newBufferedWriter(Paths.get("build", this.fileName.generateFileName()), UTF_8, CREATE, APPEND) ) {

			//今日の日付を記述
			System.out.println(this.header.generateHeader());
			writer.write(this.header.generateHeader());
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
