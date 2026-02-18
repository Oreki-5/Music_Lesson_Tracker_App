package com.Oreki.Music_Tracker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MusicTrackerApplicationTests {

	@Autowired
	private StudentDao studentDao;

	@Test
	void contextLoads() throws Exception {
		
	}
}
