package com.cachedInsights.briefly.model.response;

import com.cachedInsights.briefly.model.request.Content;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Candidate {
    private Content content;
    private String finishReason;
    private Double avgLogprobs;
}
