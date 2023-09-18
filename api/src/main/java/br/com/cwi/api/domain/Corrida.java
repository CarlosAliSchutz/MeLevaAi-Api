package br.com.cwi.api.domain;

import br.com.cwi.api.domain.enums.StatusCorrida;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Builder @AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Corrida {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private double inicioX;
    private double inicioY;
    private double fimX;
    private double fimY;
    private LocalDateTime horaInicio;
    private LocalDateTime horaChegada;
    @Enumerated(STRING)
    private StatusCorrida status;

    @ManyToOne()
    @JoinColumn(name = "passageiro_id")
    private Passageiro passageiro;

    @ManyToOne()
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    private Integer scoreMotorista;

    private Integer scorePassageiro;

}
