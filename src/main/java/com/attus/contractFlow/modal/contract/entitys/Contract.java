package com.attus.contractFlow.modal.contract.entitys;

import com.attus.contractFlow.dto.request.contract.ContractParticipantDTO;
import com.attus.contractFlow.dto.request.contract.ContractRecordDTO;
import com.attus.contractFlow.dto.request.contract.CreateContractRequestDTO;
import com.attus.contractFlow.modal.contract.enums.ContractStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

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

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContractParticipant> parties = new ArrayList<>();

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContractRecord> records = new ArrayList<>();

    public void addContractParticipant(ContractParticipantDTO dto) {
        ContractParticipant participant = new ContractParticipant(dto);
        participant.setContract(this);
        parties.add(participant);
    }

    public void addContractRecords(ContractRecordDTO dto) {
        ContractRecord record = new ContractRecord(dto);
        record.setContract(this);
        records.add(record);
    }

    public Contract(CreateContractRequestDTO dto) {
        this.creationDate = LocalDate.now();
        this.status = ContractStatus.ACTIVE;
        this.description = dto.getDescription();
        addContractRecords(dto.getRecord());
        dto.getParticipants().forEach(this::addContractParticipant);

    }
}