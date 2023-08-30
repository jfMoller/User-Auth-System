package com.example.api.dto;

import com.example.api.dto.enums.ResponseStatus;

public class JsonResponse {


    private static String json;

    public JsonResponse(ResponseStatus responseStatus) {
        json = String.format("{\"%s\": true}",
                responseStatus);
    }

    public JsonResponse(ResponseStatus responseStatus, String message) {
        json = String.format("{\"%s\": true, \"message\": \"%s\"}",
                responseStatus, message);
    }

    public JsonResponse(ResponseStatus responseStatus, String errorType, String message) {
        json = String.format("{\"%s\": true, \"errorType\": \"%s\", \"message\": \"%s\"}",
                responseStatus, errorType, message);
    }

    public String send() {
        return json;
    }
}
