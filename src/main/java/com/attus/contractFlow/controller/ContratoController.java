package com.attus.contractFlow.controller;

import com.attus.contractFlow.dto.request.contrato.CriarContratoRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @PostMapping
    public ResponseEntity<CriarContratoRequestDTO> criarContrato(@RequestBody CriarContratoRequestDTO criarContratoRequestDTO) {
        try {
            return new ResponseEntity<>(criarContratoRequestDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
