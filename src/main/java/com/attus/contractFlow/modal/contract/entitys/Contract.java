package com.attus.contractFlow.modal.contract.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

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

    // private List<ContractParticipant> contractParticipants;
    // private List<ContractRecord> contractRecords;
}