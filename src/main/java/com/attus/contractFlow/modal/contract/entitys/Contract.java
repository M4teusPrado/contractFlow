package com.attus.contractFlow.modal.contract.entitys;

import com.attus.contractFlow.dto.request.contract.create.CreateContractParticipantDTO;
import com.attus.contractFlow.dto.request.contract.create.CreateContractEventDTO;
import com.attus.contractFlow.dto.request.contract.create.CreateContractRequestDTO;
import com.attus.contractFlow.modal.contract.enums.ContractStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contractNumber")
    private Integer contractNumber;

    @Column(name = "creationDate")
    private LocalDate creationDate;

    @Column(name = "updateDate")
    private LocalDate updateDate;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ContractStatus status;

    @Setter(lombok.AccessLevel.NONE)
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContractParticipant> parties = new ArrayList<>();

    @Setter(lombok.AccessLevel.NONE)
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContractEvents> records = new ArrayList<>();

    public void addContractParticipant(CreateContractParticipantDTO dto) {
        ContractParticipant participant = new ContractParticipant(dto);
        participant.setContract(this);
        parties.add(participant);
    }

    public void addContractRecords(CreateContractEventDTO dto) {
        ContractEvents record = new ContractEvents(dto);
        record.setContract(this);
        records.add(record);
    }

    public Contract() {
    }

    public Contract(CreateContractRequestDTO dto) {
        this.creationDate = LocalDate.now();
        this.status = ContractStatus.ACTIVE;
        this.description = dto.getDescription();

        if (dto.getParticipants() == null || dto.getParticipants().isEmpty()) {
            throw new IllegalArgumentException("O contrato deve ter pelo menos um participante.");
        }

        dto.getParticipants().forEach(this::addContractParticipant);

        if (dto.getRecord() == null) {
            throw new IllegalArgumentException("O contrato deve conter pelo menos um registro de evento.");
        }

        addContractRecords(dto.getRecord());

        valid();
    }

    private void valid() {

        if (this.description == null || this.description.isBlank()) {
            throw new IllegalArgumentException("A descrição do contrato é obrigatória.");
        }
        if (this.description.length() > 255) {
            throw new IllegalArgumentException("A descrição do contrato não pode exceder 255 caracteres.");
        }
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                '}';
    }
}