package com.cachedInsights.briefly.model.request;

import lombok.*;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Content {
    private List<Part> parts ;
    private String role;
}
