package com.jojoldu.aws.jenkins;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class MemberBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberBatchApplication.class, args);
	}
}
