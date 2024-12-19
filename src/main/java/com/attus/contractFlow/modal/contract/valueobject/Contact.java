package com.attus.contractFlow.modal.contract.valueobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Contact {

    @JsonProperty("email")
    private String email;

    @JsonProperty("telefone")
    private String phone;
}