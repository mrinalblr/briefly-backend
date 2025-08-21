package com.cachedInsights.briefly.model.response;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class GeminiResponse extends SummarizerResponse{
    private List<Candidate> candidates;
    private UsageMetaData usageMetadata;
    private String modelVersion;
    private String responseId;


}
