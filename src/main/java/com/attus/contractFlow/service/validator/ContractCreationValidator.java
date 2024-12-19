package com.attus.contractFlow.service.validator;

import com.attus.contractFlow.dto.request.contract.CreateContractRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class ContractCreationValidator implements Validator<CreateContractRequestDTO> {

    @Override
    public void validate(CreateContractRequestDTO res) {
        if (res.getDescription() == null || res.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Descrição do contrato é obrigatória.");
        }

        if (res.getParticipants() == null || res.getParticipants().isEmpty()) {
            throw new IllegalArgumentException("Pelo menos um participante é necessário.");
        }
    }
}
