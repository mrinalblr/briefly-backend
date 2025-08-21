package com.cachedInsights.briefly.controller;

import com.cachedInsights.briefly.model.request.SummarizerRequest;
import com.cachedInsights.briefly.model.response.SummarizerResponse;
import com.cachedInsights.briefly.model.service.SummarizerService;
import com.cachedInsights.briefly.util.PdfUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class SummarizerController {
    private final SummarizerService summarizerService;

    public SummarizerController(@Qualifier("gemini") SummarizerService summarizerService) {
        this.summarizerService = summarizerService;
    }

    @PostMapping("/summarize")
    public ResponseEntity<? extends SummarizerResponse> summarize(@RequestBody SummarizerRequest summarizerRequest) {
        return summarizerService.summarizeText(summarizerRequest.getText(), summarizerRequest.getTone());
    }

    @PostMapping("/summarize-file")
    public ResponseEntity<? extends SummarizerResponse> summarize(@RequestParam("file") MultipartFile file) {
            return summarizerService.summarizeText(PdfUtil.extractTextFromPdf(file), null);
    }
}
