package com.cachedInsights.briefly.model.service;

import com.cachedInsights.briefly.model.response.GeminiResponse;
import com.cachedInsights.briefly.model.response.SummarizerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface SummarizerService {
    public ResponseEntity<? extends SummarizerResponse> summarizeText(String query, String tone);
}
