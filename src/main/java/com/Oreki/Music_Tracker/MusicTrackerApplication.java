package com.Oreki.Music_Tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= "com.Oreki.Music_Tracker")
public class MusicTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicTrackerApplication.class, args);
		System.out.println("Hlo");
	}

}
