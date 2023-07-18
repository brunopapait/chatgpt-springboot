package br.com.papait.bruno.chatgptspringboot.services;

import br.com.papait.bruno.chatgptspringboot.dtos.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudyNotesServiceChatGPT {
  private final CreateStudyRequest createStudyRequest;
  private final WebClient webClient;

  public StudyNotesServiceChatGPT(CreateStudyRequest createStudyRequest, WebClient.Builder builder, @Value("${openai.api.key}") String apiKey) {
    this.createStudyRequest = createStudyRequest;
    this.webClient = builder
        .baseUrl("https://api.openai.com/v1/completions")
        .defaultHeader("Content-Type", "application/json")
        .defaultHeader("Authorization", String.format("Bearer %s", apiKey))
        .build();
  }

  public Mono<ChatGPTResponse> createStudyNotes(String topic) {
    var request = this.createStudyRequest.execute(topic);

    return this.webClient.post()
        .bodyValue(request)
        .retrieve()
        .bodyToMono(ChatGPTResponse.class);
  }
}
