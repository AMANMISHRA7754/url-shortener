
package com.example.urlshortner.dto;
import java.time.LocalDateTime;

public class AnalyticsResponse
{
    private String originalUrl;
    private String shortUrl;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private Long clickCount;

    public AnalyticsResponse()
    {

    }
    public AnalyticsResponse(String originalUrl,String shortUrl,LocalDateTime createdAt,LocalDateTime expiresAt,Long clickCount)
    {
        this.originalUrl=originalUrl;
        this.shortUrl=shortUrl;
        this.createdAt=createdAt;
        this.expiresAt=expiresAt;
        this.clickCount=clickCount;
    }   
    public String getOriginalUrl()
    {
        return originalUrl;
    }
    public String getShortUrl()
    {
        return shortUrl;
    }
    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }
    public LocalDateTime getExpiresAt()
    {
        return expiresAt;
    }
    public Long getClickCount()
    {
        return clickCount;
    }
   
}