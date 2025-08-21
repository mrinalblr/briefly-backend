package com.cachedInsights.briefly.exception;

import org.springframework.web.client.HttpStatusCodeException;

public class AIClientAPIException extends RuntimeException {

    public AIClientAPIException(String message) {
        super(message);
    }

    public AIClientAPIException(String message, Throwable throwable) {
        super(message, throwable );
    }
}
