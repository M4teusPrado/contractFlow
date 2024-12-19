package com.attus.contractFlow.dto.request.contract;

import com.attus.contractFlow.modal.contract.enums.RecordType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContractRecordDTO {

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("tipoRegistro")
    private RecordType recordType;
}
