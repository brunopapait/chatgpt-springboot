package br.com.papait.bruno.chatgptspringboot.controller;

import br.com.papait.bruno.chatgptspringboot.services.StudyNotesServiceChatGPT;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/study-notes")
public class StudyNotesController {
  private final StudyNotesServiceChatGPT studyNotesServiceChatGPT;

  public StudyNotesController(StudyNotesServiceChatGPT studyNotesServiceChatGPT) {
    this.studyNotesServiceChatGPT = studyNotesServiceChatGPT;
  }


  @PostMapping
  public Mono<String> createStudyNotes(@RequestParam String topic) {
    return this.studyNotesServiceChatGPT.createStudyNotes(topic)
        .map(response -> response.choises().get(0).toString());
  }
}
