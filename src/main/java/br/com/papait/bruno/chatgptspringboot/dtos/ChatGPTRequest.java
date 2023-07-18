package br.com.papait.bruno.chatgptspringboot.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ChatGPTRequest(
    String model,
    String prompt,
    Double temperatura,
    Integer maxTokens,
    Integer topP,
    Double frequencyPenalty,
    Double presencePenalty
) {
}
