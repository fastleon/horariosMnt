package com.horarios.mnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.horarios.mnt")
public class HorariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(HorariosApplication.class, args);
	}
}


