package com.attus.contractFlow.modal.contract.valueobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Contato {

    @JsonProperty("email")
    private String email;

    @JsonProperty("telefone")
    private String telefone;
}
