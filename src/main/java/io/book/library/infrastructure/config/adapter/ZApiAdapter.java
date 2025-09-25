package io.book.library.infrastructure.config.adapter;

import io.book.library.domain.entities.Message;
import io.book.library.domain.enums.MessageStatus;
import io.book.library.infrastructure.config.dto.SendMessageRequest;
import io.book.library.infrastructure.config.dto.SendMessageResponse;
import io.book.library.infrastructure.config.dto.ZApiResponse;
import io.book.library.infrastructure.config.payload.ZApiPayload;
import io.book.library.infrastructure.config.port.WhatsAppApiPort;
import io.book.library.infrastructure.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.LocalDateTime;

@Service
public class ZApiAdapter implements WhatsAppApiPort {

    @Autowired
    private final MessageRepository repo;
    private final WebClient webClient;
    private final String baseUrl;
    private final String token;
    private final String securityToken;

    public ZApiAdapter(MessageRepository repo, WebClient webClient, @Value("${zapi.base-url}") String baseUrl, @Value("${zapi.token}") String token, @Value("${zapi.security-token}") String securityToken) {
        this.repo = repo;
        this.securityToken = securityToken;
        this.webClient = WebClient.builder().defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
        this.baseUrl = baseUrl;
        this.token = token;
    }

    public SendMessageResponse sendMessage(SendMessageRequest req) {
        Message msg = new Message();
        msg.setToPhone(req.phone());
        msg.setBody(req.body());
        Message msgSaved = repo.save(msg);

        try {

            ZApiPayload payload = new ZApiPayload(req.phone(), req.body());
            System.out.println("Payload: " + payload);
            String uri = baseUrl + "/token/" + token + "/send-text";
            ZApiResponse response = webClient.post()
                    .uri(uri)
                    .header("client-token", securityToken)
                    .bodyValue(payload)
                    .retrieve()
                    .bodyToMono(ZApiResponse.class)
                    .block();

            if (response != null) {
                msg.setStatus(MessageStatus.SENT);

            } else {
                msg.setStatus(MessageStatus.FAILED);
            }

        } catch (WebClientResponseException e) {
            throw new RuntimeException("Erro ao buscar código" + e.getMessage());
        }

        msg.setUpdatedAt(LocalDateTime.now());
        repo.save(msg);
        return new SendMessageResponse(msg.getId(), msg.getStatus().toString());
    }
}


