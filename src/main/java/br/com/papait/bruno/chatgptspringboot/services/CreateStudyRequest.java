package br.com.papait.bruno.chatgptspringboot.services;

import br.com.papait.bruno.chatgptspringboot.dtos.ChatGPTRequest;
import org.springframework.stereotype.Service;

@Service
public class CreateStudyRequest {

  public ChatGPTRequest execute(String topic) {
    var question = "Quais são os pontos chaves que devo estudar sobre o seguinte assunto ? " + topic;

    return new ChatGPTRequest("text-davinci-003", question, 0.3, 2000, 1, 0.0, 0.0);
  }
}
