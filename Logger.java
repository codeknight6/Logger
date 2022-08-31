package com.codeknight.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Logger {

	private static List<String> log = new ArrayList<>();
	
	private static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	
	public static void info(String info) {
		String s = "[" + format.format(new Date()) + "] (INFO) " + info;
		log.add(s);
		System.out.println(s);
	}
	
	public static void warning(String info) {
		String s = "[" + format.format(new Date()) + "] (WARNING) " + info;
		log.add(s);
		System.out.println(s);
	}
	
	public static void error(String info) {
		String s = "[" + format.format(new Date()) + "] (ERROR) " + info;
		log.add(s);
		System.out.println(s);
	}
	
	public static void saveLog(String path) {
		try {
			FileWriter fw = new FileWriter(path);
		
			for(String s : log) fw.write(s + System.lineSeparator());
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
