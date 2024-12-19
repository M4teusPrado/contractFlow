package com.attus.contractFlow.dto.request.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateContractRequestDTO {

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("participantes")
    private List<CreateContractParticipantDTO> participants;

    @JsonProperty("registro")
    private CreateContractEventDTO record;
}

