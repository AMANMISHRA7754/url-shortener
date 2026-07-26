package com.example.urlshortner.service;
import com.example.urlshortner.repository.UrlRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UrlShortenerService {

    HashMap<String,String> urlMap=new HashMap<>();
    @Autowired
    private UrlRepository urlRepository;
    public UrlShortenerService(UrlRepository urlRepository)
    {
        this.urlRepository=urlRepository;
    }
    public String generateShortCode()
    {
        String universalSet="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        // we will be generating 4 letter code since it can generate over 14.7 million combination
        StringBuilder sb=new StringBuilder(4);



        for(int i=0;i<4;i++)
        {
         int random = (int)(Math.random() * universalSet.length());
         char ch=universalSet.charAt(random);
         sb.append(ch);
        }
        return sb.toString();
    }
    public void storeOriginalUrl(String shortCode,String OriginalUrl)
    {
        urlMap.put(shortCode,OriginalUrl);
    }
    public String getOriginalUrl(String shortCode)
    {
        if(urlMap.containsKey(shortCode))
            return urlMap.get(shortCode);
        else 
            return "error";//for the time being later we will properly handle exceptions
    }
    public String createUrl(String originalUrl)
    {
        String generatedShortCode = generateShortCode();
        storeOriginalUrl(generatedShortCode, originalUrl);
        return generatedShortCode;
    }
}
