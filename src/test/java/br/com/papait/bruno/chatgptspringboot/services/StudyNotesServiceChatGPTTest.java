package br.com.papait.bruno.chatgptspringboot.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@SpringBootTest
public class StudyNotesServiceChatGPTTest {

  @Value("${openai.api.key}")
  private String apiKey;
  private StudyNotesServiceChatGPT studyNotesServiceChatGPT;

  @BeforeEach
  public void setUp() {
    var createStudyRequest = new CreateStudyRequest();
    var webClientBuilder = WebClient.builder();
    this.studyNotesServiceChatGPT = new StudyNotesServiceChatGPT(createStudyRequest, webClientBuilder, apiKey);
  }

  @Test
  void testCreateStudyNotesSuccess() {
    var topico = "AWS Cloud";
    var studyNotesResponse = this.studyNotesServiceChatGPT.createStudyNotes(topico);

    Assertions.assertNotNull(studyNotesResponse);
    Assertions.assertInstanceOf(Mono.class, studyNotesResponse);
  }

  @Test
  void testCreateStudyNotesFaiulure() {
    Assertions.assertThrows(RuntimeException.class,
            () -> this.studyNotesServiceChatGPT.createStudyNotes(null))
        .getMessage().equals("O Tópico não pode ser nulo");
  }

  @Test
  void testCreateStudyNotesFaiulureWithError401() {
    var topico = "AWS Cloud";

    Assertions.assertThrows(WebClientResponseException.class,
        () -> {
          var response = this.studyNotesServiceChatGPT.createStudyNotes(topico);
          response.onErrorResume(WebClientResponseException.class, ex -> {
            String responseBody = ex.getResponseBodyAsString();
            HttpStatusCode statusCode = ex.getStatusCode();

            Assertions.assertEquals(401, statusCode.value());
            return Mono.error(ex);
          }).block();
        });
  }
}
