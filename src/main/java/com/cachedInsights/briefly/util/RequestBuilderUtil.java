package com.cachedInsights.briefly.util;

import com.cachedInsights.briefly.model.request.Content;
import com.cachedInsights.briefly.model.request.GeminiRequest;
import com.cachedInsights.briefly.model.request.Part;

import java.util.Collections;

public class RequestBuilderUtil {

    public static GeminiRequest summarizerRequestBuilder(String query, String tone) {
        Part part = Part
                .builder()
                .text(PromptBuilderUtil.buildPrompt(query, tone))
                .build();
        Content content = Content
                .builder()
                .parts(Collections.singletonList(part))
                .build();
        return GeminiRequest
                .builder()
                .contents(Collections.singletonList(content))
                .build();
    }
}
