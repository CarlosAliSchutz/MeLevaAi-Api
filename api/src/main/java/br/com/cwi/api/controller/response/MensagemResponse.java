package br.com.cwi.api.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MensagemResponse {

    private String mensagem;
}
