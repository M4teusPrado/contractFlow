package com.attus.contractFlow.dto.request.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CreateContractRequestDTO {

    @NotNull(message = "A descrição não pode ser nula")  // Mensagem de erro personalizada em português
    @Size(min = 1, max = 255, message = "A descrição deve ter entre 1 e 255 caracteres")  // Tamanho mínimo e máximo
    @JsonProperty("descricao")
    private String description;

    @NotNull(message = "Os participantes não podem ser nulos")
    @Size(min = 1, message = "Deve haver pelo menos um participante")  // Garantir que há pelo menos um participante
    @JsonProperty("participantes")
    private List<CreateContractParticipantDTO> participants;

    @NotNull(message = "O registro não pode ser nulo")
    @JsonProperty("registro")
    private CreateContractEventDTO record;
}

