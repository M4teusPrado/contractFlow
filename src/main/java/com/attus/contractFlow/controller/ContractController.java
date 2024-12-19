package com.attus.contractFlow.controller;


import com.attus.contractFlow.dto.request.contract.create.CreateContractRequestDTO;
import com.attus.contractFlow.dto.request.contract.update.UpdateContractRequestDTO;
import com.attus.contractFlow.dto.response.CreateContractResponseDTO;
import com.attus.contractFlow.dto.response.UpdateContractResponseDTO;
import com.attus.contractFlow.service.ContractCreationService;
import com.attus.contractFlow.service.ContractUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contrato")
public class ContractController {

    private final ContractCreationService contractCreationService;
    private final ContractUpdateService contractUpdateService;

    @Autowired
    public ContractController(ContractCreationService contractCreationService, ContractUpdateService contractUpdateService) {
        this.contractCreationService = contractCreationService;
        this.contractUpdateService = contractUpdateService;
    }

    @PostMapping("/criar")
    public ResponseEntity<CreateContractResponseDTO> createContract(@RequestBody CreateContractRequestDTO request) {
        CreateContractResponseDTO response = contractCreationService.createContract(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/alterar/{contractId}")
    public ResponseEntity<UpdateContractResponseDTO> updateContract(@PathVariable Integer contractId, @RequestBody UpdateContractRequestDTO request) {
        UpdateContractResponseDTO response = contractUpdateService.updateContract(contractId, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}