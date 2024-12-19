package com.attus.contractFlow.dto.request.contract.update;

import com.attus.contractFlow.modal.contract.valueobject.Contact;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateContractParticipantDTO {

    @NotNull(message = "O contato não pode ser nulo")
    @JsonProperty("contatos")
    private Contact contact;
}
