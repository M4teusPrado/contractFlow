package com.attus.contractFlow.dto.request.contrato;

import com.attus.contractFlow.modal.contract.enums.TipoParticipante;
import com.attus.contractFlow.modal.contract.enums.TipoRegistro;
import com.attus.contractFlow.modal.contract.valueobject.Contato;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CriarContratoRequestDTO {

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("participantes")
    private List<ParticipanteContratoDTO> participantes;

    @JsonProperty("registro")
    private RegistroContratoDTO registro;
}

@Data
class ParticipanteContratoDTO {

    @JsonProperty("nomeCompleto")
    private String nomeCompleto;

    @JsonProperty("documentoIdentificacao")
    private String documentoIdentificacao;

    @JsonProperty("tipoParticipante")
    private TipoParticipante tipoParticipante;

    @JsonProperty("contatos")
    private Contato contatos;
}

@Data
class RegistroContratoDTO {
    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("tipoRegistro")
    private TipoRegistro tipoRegistro;
}
