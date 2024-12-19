package com.attus.contractFlow.dto.request.contract;

import com.attus.contractFlow.modal.contract.enums.ParticipantType;
import com.attus.contractFlow.modal.contract.valueobject.Contact;
import com.attus.contractFlow.modal.contract.valueobject.IdentificationDocument;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateContractParticipantDTO {

    @NotNull(message = "O nome completo não pode ser nulo")
    @Size(min = 1, max = 255, message = "O nome completo deve ter entre 1 e 255 caracteres")
    @JsonProperty("nomeCompleto")
    private String fullName;

    @NotNull(message = "O documento de identificação não pode ser nulo")
    @JsonProperty("documentoIdentificacao")
    private IdentificationDocument identificationDocument;

    @NotNull(message = "O tipo de participante não pode ser nulo")
    @JsonProperty("tipoParticipante")
    private ParticipantType participantType;

    @NotNull(message = "O contato não pode ser nulo")
    @JsonProperty("contatos")
    private Contact contact;
}
