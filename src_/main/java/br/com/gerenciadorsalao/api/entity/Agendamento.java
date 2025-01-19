package br.com.gerenciadorsalao.api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.gerenciadorsalao.api.enums.StatusAgendamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity
@Table (name = "agendamentos")
@Getter
@Setter
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private String servico;

    private BigDecimal valor;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private StatusAgendamento status;


    
}
