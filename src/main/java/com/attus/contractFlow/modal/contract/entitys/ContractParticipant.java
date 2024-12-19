package com.attus.contractFlow.modal.contract.entitys;

import com.attus.contractFlow.dto.request.contract.create.CreateContractParticipantDTO;
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

    public ContractParticipant() {
    }

    public ContractParticipant(CreateContractParticipantDTO dto) {
        this.fullName = dto.getFullName();
        this.participantType = dto.getParticipantType();
        this.contact = dto.getContact();
        this.identificationDocument = dto.getIdentificationDocument();
        valid();
    }

    private void valid() {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome completo do participante não pode ser vazio.");
        }

        if (fullName.length() > 255) {
            throw new IllegalArgumentException("O nome completo do participante não pode exceder 255 caracteres.");
        }

        if (participantType == null) {
            throw new IllegalArgumentException("O tipo de participante não pode ser nulo.");
        }

        if (identificationDocument == null) {
            throw new IllegalArgumentException("O documento de identificação não pode ser nulo.");
        }

        if (contact == null) {
            throw new IllegalArgumentException("As informações de contato não podem ser nulas.");
        }
    }
}