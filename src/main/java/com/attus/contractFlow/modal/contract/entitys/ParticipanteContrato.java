package com.attus.contractFlow.modal.contract.entitys;

import com.attus.contractFlow.modal.contract.valueobject.Contato;
import com.attus.contractFlow.modal.contract.valueobject.DocumentoIdentificacao;
import com.attus.contractFlow.modal.contract.enums.TipoParticipante;
import lombok.Data;

@Data
public class ParticipanteContrato {

    private Integer id;
    private String nomeCompleto;
    private DocumentoIdentificacao documentoIdentificacao;
    private TipoParticipante tipoParticipante;
    private Contato contato;
}
