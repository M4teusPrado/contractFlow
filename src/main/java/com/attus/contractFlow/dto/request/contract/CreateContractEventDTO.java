package com.attus.contractFlow.dto.request.contract;

import com.attus.contractFlow.modal.contract.enums.EventType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateContractEventDTO {

    @NotNull(message = "A descrição não pode ser nula")
    @Size(min = 1, max = 255, message = "A descrição deve ter entre 1 e 255 caracteres")
    @JsonProperty("descricao")
    private String description;

    @NotNull(message = "O tipo de registro não pode ser nulo")
    @JsonProperty("tipoRegistro")
    private EventType eventType;
}
