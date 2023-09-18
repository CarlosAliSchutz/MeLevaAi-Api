package br.com.cwi.api.domain;


import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Motorista {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private float score;
    private BigDecimal saldo;

    @OneToMany(mappedBy = "motorista")
    private List<Corrida> corridas;

    @OneToOne(mappedBy = "motorista")
    private LicencaMotorista licencaMotorista;

    @OneToOne(mappedBy = "motorista")
    private Veiculo veiculo;

}
