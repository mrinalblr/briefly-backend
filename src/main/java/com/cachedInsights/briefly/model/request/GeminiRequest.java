package com.cachedInsights.briefly.model.request;

import lombok.*;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeminiRequest {
    private List<Content> contents;
}
