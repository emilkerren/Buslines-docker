package com.sl.buslines.backend.models.response;

import com.google.gson.GsonBuilder;

public class ApiResponse {
    private int StatusCode;
    private String Message;
    private int ExecutionTime;
    private ResponseData ResponseData;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getExecutionTime() {
        return ExecutionTime;
    }

    public void setExecutionTime(int executionTime) {
        ExecutionTime = executionTime;
    }

    public ResponseData getResponseData() {
        return ResponseData;
    }

    public void setResponseData(com.sl.buslines.backend.models.response.ResponseData responseData) {
        ResponseData = responseData;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
