package com.example.urlshortner.controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.urlshortner.dto.AnalyticsResponse;
import com.example.urlshortner.dto.UrlRequest;
import com.example.urlshortner.dto.UrlResponse;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.urlshortner.service.UrlShortenerService;


@RestController
public class UrlController {
private UrlShortenerService urlshortenerservice;
UrlController(UrlShortenerService urlshortenerservice)
{
    this.urlshortenerservice=urlshortenerservice;
}
@PostMapping("/shorten")
public UrlResponse shortenurl(@RequestBody UrlRequest request) {
    String shortUrl= "http://localhost:8080/r/" + urlshortenerservice.createUrl(request.getUrl());
    return new UrlResponse(shortUrl);
}

@GetMapping("/r/{shortCode}")
public ResponseEntity<Void> originalurl(@PathVariable String shortCode)
{
    String originalUrl=urlshortenerservice.getOriginalUrl(shortCode);
    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
}
@GetMapping("/analytics/{shortCode}")
public AnalyticsResponse analytics(@PathVariable String shortCode) {
    return urlshortenerservice.getAnalytics(shortCode);
    
}

    
}
