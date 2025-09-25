package io.book.library.infrastructure.config.dto;

import io.book.library.domain.enums.MessageStatus;

public record SendMessageResponse(Long messageId, String status) {
}
