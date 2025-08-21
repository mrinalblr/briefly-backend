package com.cachedInsights.briefly.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {
    @Value("${google.api.key}")
    public String apiKey;
    @Value("${google.gemini.base.url}")
    public String baseURL;
}
