package br.com.papait.bruno.chatgptspringboot.services;

import br.com.papait.bruno.chatgptspringboot.dtos.ChatGPTResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudyNotesServiceChatGPT {
  private final CreateStudyRequest createStudyRequest;
  private final WebClient webClient;

//  @Value("${openai.api.key}")
//  private String apiKey;

  public StudyNotesServiceChatGPT(CreateStudyRequest createStudyRequest, WebClient.Builder builder) {
    this.createStudyRequest = createStudyRequest;
    this.webClient = builder
        .baseUrl("https://api.openai.com/v1/completions")
        .defaultHeader("Content-Type", "application/json")
        .defaultHeader("Authorization", String.format("Bearer %s", "qweqwe"))
        .build();
  }

  public Mono<ChatGPTResponse> createStudyNotes(String topic) {
    var request = this.createStudyRequest.execute(topic);

    var teste =  this.webClient.post()
        .bodyValue(request)
        .retrieve()
        .bodyToMono(ChatGPTResponse.class);

    return teste;
  }
}
