package com.attus.contractFlow.service;

import com.attus.contractFlow.dto.request.contract.create.CreateContractRequestDTO;
import com.attus.contractFlow.dto.response.CreateContractResponseDTO;
import org.springframework.stereotype.Service;


@Service
public interface ContractCreationService {
    CreateContractResponseDTO createContract(CreateContractRequestDTO request);
}
