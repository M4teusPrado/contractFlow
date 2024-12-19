package com.attus.contractFlow.modal.contract.entitys;

import com.attus.contractFlow.dto.request.contract.CreateContractParticipantDTO;
import com.attus.contractFlow.modal.contract.enums.ParticipantType;
import com.attus.contractFlow.modal.contract.valueobject.Contact;
import com.attus.contractFlow.modal.contract.valueobject.IdentificationDocument;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "participants")
public class ContractParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullName")
    private String fullName;

    @Embedded
    @Column(name = "document")
    private IdentificationDocument identificationDocument;

    @Enumerated(EnumType.STRING)
    @Column(name = "participantType")
    private ParticipantType participantType;

    @Embedded
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "contractNumber")
    private Contract contract;

    public ContractParticipant(CreateContractParticipantDTO dto) {
        this.fullName = dto.getFullName();
        this.participantType = dto.getParticipantType();
        this.contact = dto.getContact();
        this.identificationDocument = dto.getIdentificationDocument();
    }
}