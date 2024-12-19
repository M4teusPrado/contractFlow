package com.attus.contractFlow.modal;

import com.attus.contractFlow.dto.request.contract.create.CreateContractEventDTO;
import com.attus.contractFlow.modal.contract.entitys.ContractEvents;
import com.attus.contractFlow.modal.contract.enums.EventType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class TestContractEvents {

    private CreateContractEventDTO dto;

    @BeforeEach
    void setUp() {
        dto = new CreateContractEventDTO();
        dto.setEventType(EventType.ASSINATURA); // Enum válido
        dto.setDescription("Evento válido");
    }

    @Test
    void shouldCreateContractEventsWithValidData() {
        // Arrange


        // Act
        ContractEvents event = new ContractEvents(dto);

        // Assert
        Assertions.assertNotNull(event);
        Assertions.assertEquals(EventType.ASSINATURA, event.getEventType());
        Assertions.assertEquals("Evento válido", event.getDescription());
        Assertions.assertEquals(LocalDate.now(), event.getRecordDate());
    }

    @Test
    void shouldThrowExceptionWhenEventTypeIsNull() {
        // Arrange

        dto.setEventType(null);


        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new ContractEvents(dto)
        );

        Assertions.assertEquals("O tipo de evento não pode ser nulo.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsNull() {
        // Arrange
        dto.setDescription(null);

        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new ContractEvents(dto)
        );

        Assertions.assertEquals("A descrição do evento não pode ser vazia.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDescriptionExceeds255Characters() {
        // Arrange
        String longDescription = "a".repeat(256);
        dto.setDescription(longDescription);

        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new ContractEvents(dto)
        );

        Assertions.assertEquals("A descrição do evento não pode exceder 255 caracteres.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsEmpty() {
        // Arrange
        dto.setDescription("  "); // Descrição vazia (apenas espaços)

        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new ContractEvents(dto)
        );

        Assertions.assertEquals("A descrição do evento não pode ser vazia.", exception.getMessage());
    }
}

