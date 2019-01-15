package com.example.demospringdatacouchbaseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication
@EnableCouchbaseRepositories
public class DemoSpringDataCouchbaseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataCouchbaseAppApplication.class, args);
	}

}

