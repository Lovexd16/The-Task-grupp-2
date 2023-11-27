package com.thetask.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThetaskApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testIfToDoIsLate() {
		long testTime = 1601097035961L;
		long testTime2 = 1801097035961L;
		assertTrue(testTime < ThetaskApplication.getCurrentTime());
		assertFalse(testTime2 < ThetaskApplication.getCurrentTime());
	}

}
