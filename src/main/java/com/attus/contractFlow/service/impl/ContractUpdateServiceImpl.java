package com.attus.contractFlow.service.impl;

import com.attus.contractFlow.dto.request.contract.update.UpdateContractRequestDTO;
import com.attus.contractFlow.dto.response.UpdateContractResponseDTO;
import com.attus.contractFlow.modal.contract.entitys.Contract;
import com.attus.contractFlow.repository.ContractRepository;
import com.attus.contractFlow.service.ContractUpdateService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractUpdateServiceImpl implements ContractUpdateService {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractUpdateServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }


    @Override
    public UpdateContractResponseDTO updateContract(Integer id, UpdateContractRequestDTO request) {

        Optional<Contract> contractOptional = contractRepository.findById(id);

        if (contractOptional.isEmpty()) {
            throw new EntityNotFoundException("Contract not found with ID: " + id);
        }


        Contract contract = contractOptional.get();

        return null;
    }

    @Override
    public Optional<Contract> findContractById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public Contract updateContractWithNonNullFields(Contract contract, UpdateContractRequestDTO request) {
        return null;
    }
}
