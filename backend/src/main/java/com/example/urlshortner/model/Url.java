package com.example.urlshortner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Url {
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
}
