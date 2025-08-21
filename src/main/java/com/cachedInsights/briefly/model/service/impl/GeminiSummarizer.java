package com.cachedInsights.briefly.model.service.impl;

import com.cachedInsights.briefly.config.PropertiesConfig;
import com.cachedInsights.briefly.constant.SummarizerConstant;
import com.cachedInsights.briefly.exception.AIClientAPIException;
import com.cachedInsights.briefly.model.request.GeminiRequest;
import com.cachedInsights.briefly.model.response.GeminiResponse;
import com.cachedInsights.briefly.model.service.SummarizerService;
import com.cachedInsights.briefly.util.RequestBuilderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service("gemini")
public class GeminiSummarizer implements SummarizerService {
    private Logger logger = LoggerFactory.getLogger(GeminiSummarizer.class);
    private final RestTemplate restTemplate;
    private final PropertiesConfig propertiesConfig;

    public GeminiSummarizer(RestTemplate restTemplate, PropertiesConfig propertiesConfig) {
        this.restTemplate = restTemplate;
        this.propertiesConfig = propertiesConfig;
    }

    @Override
    public ResponseEntity<GeminiResponse> summarizeText(String query, String tone) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(SummarizerConstant.GEMINI_API_KEY_HEADER, propertiesConfig.apiKey);
        HttpEntity<GeminiRequest> entity = new HttpEntity<>(RequestBuilderUtil.summarizerRequestBuilder(query, tone), headers);
        String url = propertiesConfig.baseURL + SummarizerConstant.GEMINI_AI_URI;
        try{
            return restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    GeminiResponse.class
            );
        } catch (HttpStatusCodeException ex) {
            logger.error("Exception occurred while calling upstream API : {}, with status code {}", ex.getMessage(), ex.getStatusCode());
            throw new AIClientAPIException(ex.getMessage());
        }

    }
}
