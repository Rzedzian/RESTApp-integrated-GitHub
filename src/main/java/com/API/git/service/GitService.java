package com.API.git.service;

import com.API.git.service.dto.ErrorDto;
import com.API.git.service.dto.GitDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class GitService {
    private static final String GIT_URL = "https://api.github.com/users/";
    @Autowired
    private RestTemplate restTemplate;

    public List getAllUserRepo(String userName, String acceptHeader) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", acceptHeader);
            ResponseEntity<String> responseEntity = restTemplate.exchange(GIT_URL + "{userName}/repos",
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    String.class,
                    userName);
            ObjectMapper objectMapper = new ObjectMapper();
            List<GitDto> gitDtoList;

            try {
                gitDtoList = objectMapper.readValue(responseEntity.getBody(), new TypeReference<List<GitDto>>() {
                });
            } catch (IOException e) {
                throw new RuntimeException("JSONException occurred");
            }
            return gitDtoList;

        } catch (HttpClientErrorException e) {
            List<ErrorDto> errors = new ArrayList<>();
            ErrorDto error = new ErrorDto(e.getStatusCode().value(), e.getStatusText());
            errors.add(error);
            return errors;
        }
    }
}
