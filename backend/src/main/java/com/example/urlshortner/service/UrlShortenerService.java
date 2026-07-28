package com.example.urlshortner.service;
import com.example.urlshortner.repository.UrlRepository;
import com.example.urlshortner.model.Url;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.LocalDateTime;
import com.example.urlshortner.dto.AnalyticsResponse;
@Service
public class UrlShortenerService {

    private final UrlRepository urlRepository;
    public UrlShortenerService(UrlRepository urlRepository)
    {
        this.urlRepository=urlRepository;
    }
    public String generateShortCode()
    {
        String universalSet="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        // we will be generating 4 letter code since it can generate over 14.7 million combination
        while(true)
        {
        StringBuilder sb=new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
         int random = (int)(Math.random() * universalSet.length());
         char ch=universalSet.charAt(random);
         sb.append(ch);
        }
        String shortCode=sb.toString();
        Optional<Url> urlcontainer=urlRepository.findByShortCode(shortCode);
        if(!urlcontainer.isPresent())
          return shortCode;
    }
    }
    public void storeOriginalUrl(String shortCode,String originalUrl)
    {
        Url url=new Url();
        url.setShortCode(shortCode);
        url.setOriginalUrl(originalUrl);
        LocalDateTime currentTime=LocalDateTime.now();
        url.setCreatedAt(currentTime);
        url.setExpiresAt(currentTime.plusHours(1));
        url.setReservedUntil(currentTime.plusDays(2));
        url.setClickCount(0L);
        urlRepository.save(url);

    }
    public String getOriginalUrl(String shortCode)
    {
        
       Optional<Url> url=urlRepository.findByShortCode(shortCode);
       if(!url.isPresent())
        return "THE SHORTCODE IS NOT FOUND";
       Url actualUrl=url.get();
       LocalDateTime expirationTime=actualUrl.getExpiresAt();
       LocalDateTime currentTime=LocalDateTime.now();
       if(expirationTime.isAfter(currentTime))
        {
            actualUrl.setClickCount(actualUrl.getClickCount() + 1);
            urlRepository.save(actualUrl);
            return actualUrl.getOriginalUrl();
        }
        else
        {
            return "SORRY THE SHORTCODE EXPIRED";
        }
    }
    public String createUrl(String originalUrl)
    {
        String generatedShortCode = generateShortCode();
        storeOriginalUrl(generatedShortCode, originalUrl);
        return generatedShortCode;
    }

    public AnalyticsResponse getAnalytics(String shortCode)
    {
        Optional<Url> containerUrl=urlRepository.findByShortCode(shortCode);
        if(!containerUrl.isPresent())
            throw new RuntimeException("Short Url not found");

        Url actualUrl=containerUrl.get();
        LocalDateTime currentTime=LocalDateTime.now();
        LocalDateTime expirationTime=actualUrl.getExpiresAt();
        if(currentTime.isAfter(expirationTime))
            throw new RuntimeException("The ShortUrl expired ");

            AnalyticsResponse analyticsResponse=new AnalyticsResponse(actualUrl.getOriginalUrl(),"http://localhost:8080/r/"+actualUrl.getShortCode(),actualUrl.getCreatedAt(),actualUrl.getExpiresAt(),actualUrl.getClickCount());
            return analyticsResponse;
    }
}
