package com.cachedInsights.briefly.util;

import com.cachedInsights.briefly.constant.SummarizerConstant;

public class PromptBuilderUtil {
    public static String buildPrompt(String query, String tone) {
        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder
                .append(SummarizerConstant.SUMMARIZER_PROMPT)
                .append("\n")
                .append(query);
        return promptBuilder.toString();

    }
}
