package com.thetask.demo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThetaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThetaskApplication.class, args);
		getCurrentTime();

	}

	public static long getCurrentTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		long currentTime = zonedDateTime.toInstant().toEpochMilli();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM HH:mm");
		String formattedDateTime = localDateTime.format(dateFormatter);
		System.out.println("Time, milliseconds: " + currentTime);
		System.out.println("Time, formatted: " + formattedDateTime);
		return currentTime;

	}

}
