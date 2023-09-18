package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DepositarCreditoPassageiroRequest {

    @NotNull(message = "Deve informar a quantia que quer depositar.")
    private BigDecimal saldo;
}
