package io.book.library.infrastructure.config.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ZApiResponse(String messageId,
                           String detail) {
}
