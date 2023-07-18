package br.com.papait.bruno.chatgptspringboot.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudyNotesControllerTest {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void testCreateStudyNotesSuccess() {
    this.webTestClient
        .post()
        .uri(uriBuilder -> uriBuilder
            .path("/study-notes")
            .queryParam("topic", "AWS Cloud")
            .build()
        )
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$").isNotEmpty();
  }

  @Test
  void testCreateStudyNotesFaiulure() {
    this.webTestClient
        .post()
        .uri(uriBuilder -> uriBuilder
            .path("/study-notes")
            .queryParam("topic", "AWS Cloud")
            .build()
        )
        .exchange()
        .expectStatus()
        .is5xxServerError()
        .expectBody()
        .jsonPath("$").isNotEmpty();
  }
}
