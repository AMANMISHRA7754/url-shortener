package com.example.urlshortner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Url {

    public Url()
    {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String shortCode;
    @Column(nullable=false)
    private String originalUrl;
    @Column(nullable=false)
    private LocalDateTime createdAt;
    @Column (nullable=false)
    private LocalDateTime expiresAt;
    @Column (nullable=false)
    private LocalDateTime reservedUntil;
    @Column (nullable=false)
    private Long clickCount;

    public void setId(Long id)
    {
        this.id=id;
    }
    public Long getId()
    {
        return id;
    }

    public String getShortCode()
    {
        return shortCode;
    }
    public void setShortCode(String shortCode)
    {
        this.shortCode=shortCode;
    }

    public String getOriginalUrl()
    {
        return originalUrl;
    }
    public void setOriginalUrl(String originalUrl)
    {
        this.originalUrl=originalUrl;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt=createdAt;
    }

    public LocalDateTime getExpiresAt()
    {
        return expiresAt;
    }
    public void setExpiresAt(LocalDateTime expiresAt)
    {
        this.expiresAt=expiresAt;
    }

    public LocalDateTime getReservedUntil()
    {
        return reservedUntil;
    }
    public void setReservedUntil(LocalDateTime reservedUntil)
    {
        this.reservedUntil=reservedUntil;
    }

    public Long getClickCount()
    {
        return clickCount;
    }
    public void setClickCount(Long clickCount)
    {
        this.clickCount=clickCount;
    }


}
