package br.com.papait.bruno.chatgptspringboot.dtos;

import java.util.List;

public record ChatGPTResponse(
List<Choise> choises
) {
}
