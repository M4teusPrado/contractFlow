package com.attus.contractFlow.dto.request.contract.update;

import com.attus.contractFlow.dto.request.contract.create.CreateContractParticipantDTO;
import com.attus.contractFlow.modal.contract.enums.ContractStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UpdateContractRequestDTO {

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("status")
    private ContractStatus status;

    @JsonProperty("participantes")
    private List<CreateContractParticipantDTO> participants;
}

