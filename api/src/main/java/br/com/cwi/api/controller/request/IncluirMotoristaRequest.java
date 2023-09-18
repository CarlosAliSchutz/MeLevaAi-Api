package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class IncluirMotoristaRequest {

    @NotBlank(message = "Nome não pode ser vazio.")
    private String nome;
    @NotNull(message = "Data de nascimento não pode ser vazio.")
    private LocalDate dataNascimento;
    @NotBlank(message = "CPF não pode ser vazio.")
    @CPF(message = "Informe um CPF válido")
    private String cpf;
    @NotNull(message = "Saldo não pode ser vazio.")
    private BigDecimal saldo;
}
