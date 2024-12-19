package com.attus.contractFlow.modal.contract.entitys;

import com.attus.contractFlow.dto.request.contract.ContractRecordDTO;
import com.attus.contractFlow.modal.contract.enums.RecordType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class ContractRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "recordType")
    private RecordType recordType;

    @Column(name = "recordDate")
    private LocalDate recordDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "contractNumber")
    private Contract contract;

    public ContractRecord(ContractRecordDTO dto) {
        this.recordType = dto.getRecordType();
        this.description = dto.getDescription();
        this.recordDate = LocalDate.now();
    }
}
