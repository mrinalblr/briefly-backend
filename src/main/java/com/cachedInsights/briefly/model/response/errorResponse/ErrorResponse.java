package com.cachedInsights.briefly.model.response.errorResponse;

import lombok.*;
import org.springframework.http.HttpStatusCode;

import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private Instant timeStamp;
    private String errorMessage;
    private HttpStatusCode httpStatusCode;
}
