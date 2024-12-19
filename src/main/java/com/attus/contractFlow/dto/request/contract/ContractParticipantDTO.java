package com.attus.contractFlow.dto.request.contract;

import com.attus.contractFlow.modal.contract.enums.ParticipantType;
import com.attus.contractFlow.modal.contract.valueobject.Contact;
import com.attus.contractFlow.modal.contract.valueobject.IdentificationDocument;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContractParticipantDTO {

    @JsonProperty("nomeCompleto")
    private String fullName;

    @JsonProperty("documentoIdentificacao")
    private IdentificationDocument identificationDocument;

    @JsonProperty("tipoParticipante")
    private ParticipantType participantType;

    @JsonProperty("contatos")
    private Contact contact;
}
