package com.thetask.demo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {
    
    
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
