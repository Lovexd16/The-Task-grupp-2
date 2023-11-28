package com.thetask.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CurrentTimeTests {
    
    @Test
	void testIfToDoIsLate() {
		long testTime = 1601097035961L;
		long testTime2 = 1801097035961L;
		assertTrue(testTime < CurrentTime.getCurrentTime());
		assertFalse(testTime2 < CurrentTime.getCurrentTime());
	}
}
