package com.example.customerror.service;

import com.example.customerror.domain.UserGithub;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
@Slf4j
public class GithubService {

    private final RestTemplate restTemplate;

    //@Async
    public CompletableFuture<UserGithub> findUser(String user) throws InterruptedException {
        log.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        UserGithub result = restTemplate.getForObject(url, UserGithub.class);
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(result);
    }
}
