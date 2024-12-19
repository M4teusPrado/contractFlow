package com.attus.contractFlow.modal.contract.entitys;

import com.attus.contractFlow.dto.request.contract.CreateContractEventDTO;
import com.attus.contractFlow.modal.contract.enums.EventType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class ContractEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "eventType")
    private EventType eventType;

    @Column(name = "recordDate")
    private LocalDate recordDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "contractNumber")
    private Contract contract;

    public ContractEvents(CreateContractEventDTO dto) {
        this.eventType = dto.getEventType();
        this.description = dto.getDescription();
        this.recordDate = LocalDate.now();
        
        valid();
    }

    private void valid() {
        if (eventType == null) {
            throw new IllegalArgumentException("O tipo de evento não pode ser nulo.");
        }

        if (description != null && description.length() > 255) {
            throw new IllegalArgumentException("A descrição do evento não pode exceder 255 caracteres.");
        }

        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do evento não pode ser vazia.");
        }
    }
}
