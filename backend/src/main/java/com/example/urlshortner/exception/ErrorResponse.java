package com.example.urlshortner.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String message;
    public ErrorResponse(LocalDateTime timestamp,int statusCode, String error, String message)
    {
        this.timestamp=timestamp;
        this.statusCode=statusCode;
        this.error=error;
        this.message=message;
    }
    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }
    public int getStatusCode()
    {
        return statusCode;
    }
    public String getError()
    {
        return error;
    }
    public String getMessage()
    {
        return message;
    }
    
}
