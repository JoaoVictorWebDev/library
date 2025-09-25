package io.book.library.infrastructure.config.port;

import io.book.library.infrastructure.config.dto.SendMessageRequest;
import io.book.library.infrastructure.config.dto.SendMessageResponse;

public interface WhatsAppApiPort {
    SendMessageResponse sendMessage(SendMessageRequest req);

}
