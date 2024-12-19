package com.attus.contractFlow.service.impl;

import com.attus.contractFlow.dto.request.contract.create.CreateContractRequestDTO;
import com.attus.contractFlow.dto.response.CreateContractResponseDTO;
import com.attus.contractFlow.modal.contract.entitys.Contract;
import com.attus.contractFlow.repository.ContractRepository;
import com.attus.contractFlow.service.ContractCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractCreationServiceImpl implements ContractCreationService {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractCreationServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public CreateContractResponseDTO createContract(CreateContractRequestDTO request) {
        return createContractResponse(contractRepository.save(new Contract(request)));
    }

    public CreateContractResponseDTO createContractResponse(Contract contract) {
        return new CreateContractResponseDTO((contract.getContractNumber()));
    }
}
