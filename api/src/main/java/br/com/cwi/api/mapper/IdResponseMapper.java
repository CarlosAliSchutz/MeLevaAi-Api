package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.IdResponse;

public class IdResponseMapper {
    public static IdResponse toResponse(Long id) {
        return IdResponse.builder().id(id).build();
    }
}
