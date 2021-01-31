package com.lok.pojo;

import lombok.Data;

import javax.json.bind.annotation.JsonbProperty;

@Data
public class ResponseJson {
    @JsonbProperty("status")
    private boolean validResponse;
    private int statusCode;
    private String message;
}