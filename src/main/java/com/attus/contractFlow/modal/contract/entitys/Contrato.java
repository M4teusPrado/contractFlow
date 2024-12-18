package com.attus.contractFlow.modal.contract.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroContrato")
    private Integer numeroContrato;

    @Column(name = "dataCriacao")
    private LocalDate dataCriacao;

    @Column(name = "dataAtualizacap")
    private LocalDate dataAtualizacao;

    @Column(name = "descricao")
    private String descricao;

//    private List<ParticipanteContrato> participantesContrato;
//    private List<RegistroContrato> registrosContrato;
}
