package com.attus.contractFlow.service;

import com.attus.contractFlow.dto.request.contract.CreateContractRequestDTO;
import org.springframework.stereotype.Service;


@Service
public interface ContractCreationService {
    void createContract(CreateContractRequestDTO request);
}
