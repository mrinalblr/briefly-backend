package com.cachedInsights.briefly.model.response;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UsageMetaData {
    private int promptTokenCount;
    private int candidatesTokenCount;
    private int totalTokenCount;
    private List<Token> promptTokensDetails;
    private List<Token> candidatesTokensDetails;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
class Token {
    private String modality;
    private int tokenCount;
}
