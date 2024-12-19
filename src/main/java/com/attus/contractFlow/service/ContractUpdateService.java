package com.attus.contractFlow.service;

import com.attus.contractFlow.dto.request.contract.update.UpdateContractRequestDTO;
import com.attus.contractFlow.dto.response.UpdateContractResponseDTO;
import com.attus.contractFlow.modal.contract.entitys.Contract;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface ContractUpdateService {
    UpdateContractResponseDTO updateContract(Integer id, UpdateContractRequestDTO request);

    Optional<Contract> findContractById(Integer id) throws Exception;

    Contract updateContractWithNonNullFields(Contract contract, UpdateContractRequestDTO request);
}
