package org.example.library_management_system_data.dto;

import java.time.Instant;

public class ApiError {
    private  String timestamp;
    private String message;
    private String statusCode;
    private String error;
    private String path;
    public ApiError(String message,String statusCode, String error, String path){
        this.timestamp = Instant.now().toString();
        this.message = message;
        this.statusCode = statusCode;
        this.error = error;
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
