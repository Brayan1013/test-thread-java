package com.example.customerror;

import com.example.customerror.dao.StudentDao;
import com.example.customerror.domain.Student;
import com.example.customerror.domain.UserGithub;
import com.example.customerror.service.GithubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class CustomErrorApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CustomErrorApplication.class);


	private final StudentDao  studentDao;
	private final GithubService githubService;

	public CustomErrorApplication(StudentDao studentDao, GithubService githubService) {
		this.studentDao = studentDao;
		this.githubService = githubService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomErrorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Start the clock
		long start = System.currentTimeMillis();

		//Kick of multiple, asynchronous lookups
		CompletableFuture<UserGithub> page1 = githubService.findUser("PivotalSoftware");
		CompletableFuture<UserGithub> page2 = githubService.findUser("CloudFoundry");
		CompletableFuture<UserGithub> page3 = githubService.findUser("Spring-Projects");

		//Wait until they are all done
		CompletableFuture.allOf(page1, page2, page3);

		//print results, including elapsed time
		logger.info("Elapsed time: " + (System.currentTimeMillis() -  start));
		logger.info("---> " + page1.get());
		logger.info("---> " + page2.get());
		logger.info("---> " + page3.get());
	}

	@Bean
	public Executor tasExecutor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("GithubLookup-");
		executor.initialize();
		return executor;
	}
}
