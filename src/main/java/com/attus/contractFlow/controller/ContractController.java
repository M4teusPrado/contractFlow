package com.attus.contractFlow.controller;


import com.attus.contractFlow.dto.request.contract.CreateContractRequestDTO;
import com.attus.contractFlow.dto.response.CreateContractResponseDTO;
import com.attus.contractFlow.service.ContractCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contrato")
public class ContractController {

    private final ContractCreationService contractCreationService;

    @Autowired
    public ContractController(ContractCreationService contractCreationService) {
        this.contractCreationService = contractCreationService;
    }

    @PostMapping("/criar")
    public ResponseEntity<CreateContractResponseDTO> createContract(@RequestBody CreateContractRequestDTO request) {
        CreateContractResponseDTO response = contractCreationService.createContract(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}