package com.attus.contractFlow.service.impl;

import com.attus.contractFlow.dto.request.contract.CreateContractRequestDTO;
import com.attus.contractFlow.modal.contract.entitys.Contract;
import com.attus.contractFlow.repository.ContractRepository;
import com.attus.contractFlow.service.ContractCreationService;
import com.attus.contractFlow.service.validator.ContractCreationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractCreationServiceImpl implements ContractCreationService {

    private final ContractCreationValidator validator;
    private final ContractRepository contractRepository;

    @Autowired
    public ContractCreationServiceImpl(ContractCreationValidator validator, ContractRepository contractRepository) {
        this.validator = validator;
        this.contractRepository = contractRepository;
    }

    @Override
    public void createContract(CreateContractRequestDTO request) {
        validator.validate(request);
        Contract contract = createContractEntity(request);
    }

    private Contract createContractEntity(CreateContractRequestDTO request) {
        return contractRepository.save(new Contract(request));
    }
}
