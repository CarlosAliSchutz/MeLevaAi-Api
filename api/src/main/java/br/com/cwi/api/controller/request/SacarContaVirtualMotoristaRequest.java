package br.com.cwi.api.controller.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class SacarContaVirtualMotoristaRequest {

    @NotNull(message = "Deve informar a quantia que quer sacar.")
    private BigDecimal saldo;
}
