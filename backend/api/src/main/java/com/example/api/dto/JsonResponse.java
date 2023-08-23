package com.example.api.dto;

import com.example.api.dto.enums.ResponseStatus;

public class JsonResponse {


    private static String json;
    private ResponseStatus responseStatus;
    private String message;
    private String errorType;

    public JsonResponse(ResponseStatus responseStatus) {
        this.json = String.format("{\"%s\": true}",
                responseStatus);
        ;
    }

    public JsonResponse(ResponseStatus responseStatus, String message) {
        this.json = String.format("{\"%s\": true, \"message\": \"%s\"}",
                responseStatus, message);
        ;
    }

    public JsonResponse(ResponseStatus responseStatus, String errorType, String message) {
        this.json = String.format("{\"%s\": true, \"errorType\": \"%s\", \"message\": \"%s\"}",
                responseStatus, errorType, message);
        ;
    }

    public String send() {
        return json;
    }
}
