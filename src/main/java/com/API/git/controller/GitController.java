package com.API.git.controller;

import com.API.git.service.GitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GitController {

    private final GitService gitService;

    @GetMapping("/get-all-repo/{userName}")
    public ResponseEntity<?> callRapidEndpointToGetAllPublicGitRepo(@PathVariable String userName, @RequestHeader(value="Accept") String acceptHeader) {
        return ResponseEntity.ok(gitService.getAllUserRepo(userName, acceptHeader));
    }
}
