package com.attus.contractFlow.modal.contract.entitys;

import com.attus.contractFlow.modal.contract.enums.ParticipantType;
import com.attus.contractFlow.modal.contract.valueobject.Contact;
import com.attus.contractFlow.modal.contract.valueobject.IdentificationDocument;
import lombok.Data;

@Data
public class ContractParticipant {

    private Integer id;
    private String fullName;
    private IdentificationDocument identificationDocument;
    private ParticipantType participantType;
    private Contact contact;
}
