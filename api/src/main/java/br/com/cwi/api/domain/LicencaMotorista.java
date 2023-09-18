package br.com.cwi.api.domain;

import br.com.cwi.api.domain.enums.Categoria;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class LicencaMotorista {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String numero;
    @Enumerated(STRING)
    private Categoria categoria;
    private LocalDate dataVencimento;

    @OneToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;
}
