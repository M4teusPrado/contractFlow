package com.attus.contractFlow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UpdateContractResponseDTO {
    private Integer contractId;
    private String message;
    private String timestamp;

    public UpdateContractResponseDTO(Integer contractId) {
        this.contractId = contractId;
        this.message = "Contrato alterado com sucesso!";
        this.timestamp = LocalDateTime.now().toString();
    }
}