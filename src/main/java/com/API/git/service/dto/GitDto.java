package com.API.git.service.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitDto {
    private String name;
    private GitOwnerDto owner;
    private String branches_url;
    private String blobs_url;
}
