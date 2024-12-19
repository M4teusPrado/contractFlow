package com.attus.contractFlow.modal.contract.valueobject;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class IdentificationDocument {
    private String identification;

    public IdentificationDocument() {
    }

    public IdentificationDocument(String identification) {
        this.identification = identification;
    }
}
