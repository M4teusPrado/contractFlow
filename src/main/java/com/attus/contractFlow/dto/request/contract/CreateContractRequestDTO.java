package com.attus.contractFlow.dto.request.contract;

import com.attus.contractFlow.modal.contract.enums.ParticipantType;
import com.attus.contractFlow.modal.contract.enums.RecordType;
import com.attus.contractFlow.modal.contract.valueobject.Contact;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateContractRequestDTO {

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("participantes")
    private List<ContractParticipantDTO> participants;

    @JsonProperty("registro")
    private ContractRecordDTO record;
}

@Data
class ContractParticipantDTO {

    @JsonProperty("nomeCompleto")
    private String fullName;

    @JsonProperty("documentoIdentificacao")
    private String identificationDocument;

    @JsonProperty("tipoParticipante")
    private ParticipantType participantType;

    @JsonProperty("contatos")
    private Contact contact;
}

@Data
class ContractRecordDTO {

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("tipoRegistro")
    private RecordType recordType;
}