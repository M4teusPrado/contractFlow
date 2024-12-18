package com.attus.contractFlow.modal.contract.entitys;

import java.time.LocalDate;
import java.util.List;

public class Contrato {
    private Integer numeroContrato;
    private LocalDate dataCriacao;
    private String descricao;
    private List<ParticipanteContrato> participantesContrato;
    private List<RegistroContrato> registrosContrato;
}
