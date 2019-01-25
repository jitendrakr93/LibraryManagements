package com.library.LibraryManagements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.library.LibraryManagements.*"})
public class LibraryManagementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementsApplication.class, args);
	}

}

