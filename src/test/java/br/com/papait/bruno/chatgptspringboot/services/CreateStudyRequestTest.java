package br.com.papait.bruno.chatgptspringboot.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateStudyRequestTest {

  private CreateStudyRequest createStudyRequest;
  private String question;

  @BeforeEach
  public void setUp() {
    this.createStudyRequest = new CreateStudyRequest();
    this.question = "Quais são os pontos chaves que devo estudar sobre o seguinte assunto ? ";
  }

  @Test
  void testCreateStudyRequestSucces() {
    var topico = "AWS Cloud";
    var createStudyRequest = this.createStudyRequest.execute(topico);

    Assertions.assertNotNull(createStudyRequest);
    Assertions.assertEquals(createStudyRequest.prompt(), this.question + topico);
  }

  @Test
  void testCreateStudyRequestFailure() {
    Assertions.assertThrows(RuntimeException.class,
            () -> this.createStudyRequest.execute(null))
        .getMessage().equals("O Tópico não pode ser nulo");
  }
}
