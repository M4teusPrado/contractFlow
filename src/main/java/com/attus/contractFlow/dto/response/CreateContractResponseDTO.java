package com.attus.contractFlow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateContractResponseDTO {
    private Integer contractId;
    private String message;
    private String timestamp;

    public CreateContractResponseDTO(Integer contractId) {
        this.contractId = contractId;
        this.message = "Contract created successfully";
        this.timestamp = LocalDateTime.now().toString();
    }
}