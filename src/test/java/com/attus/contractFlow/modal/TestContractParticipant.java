package com.attus.contractFlow.modal;

import com.attus.contractFlow.dto.request.contract.CreateContractParticipantDTO;
import com.attus.contractFlow.modal.contract.entitys.ContractParticipant;
import com.attus.contractFlow.modal.contract.enums.ParticipantType;
import com.attus.contractFlow.modal.contract.valueobject.Contact;
import com.attus.contractFlow.modal.contract.valueobject.IdentificationDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestContractParticipant {

    private CreateContractParticipantDTO dto;

    @BeforeEach
    void setUp() {
        dto = new CreateContractParticipantDTO();
        dto.setFullName("Jose do Prado");
        dto.setParticipantType(ParticipantType.ADVOGADO);

        Contact contact = new Contact();
        contact.setEmail("jose@gmail.com");
        contact.setPhone("(15)998047229");
        dto.setContact(contact);

        IdentificationDocument document = new IdentificationDocument("46900619800");
        dto.setIdentificationDocument(document);


    }

    @Test
    void shouldCreateContractParticipantWithValidData() {
        // Act
        ContractParticipant participant = new ContractParticipant(dto);

        // Assert
        Assertions.assertNotNull(participant);
        Assertions.assertEquals("Jose do Prado", participant.getFullName());
        Assertions.assertEquals(ParticipantType.ADVOGADO, participant.getParticipantType());
        Assertions.assertEquals("jose@gmail.com", participant.getContact().getEmail());
        Assertions.assertEquals("(15)998047229", participant.getContact().getPhone());
        Assertions.assertEquals("46900619800", participant.getIdentificationDocument().getIdentification());
    }

    @Test
    void shouldThrowExceptionWhenFullNameIsNull() {
        // Arrange
        dto.setFullName(null);

        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new ContractParticipant(dto)
        );

        Assertions.assertEquals("O nome completo do participante não pode ser vazio.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenFullNameExceeds255Characters() {
        // Arrange
        dto.setFullName("a".repeat(256));

        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new ContractParticipant(dto)
        );

        Assertions.assertEquals("O nome completo do participante não pode exceder 255 caracteres.", exception.getMessage());

    }

    @Test
    void shouldThrowExceptionWhenParticipantTypeIsNull() {
        // Arrange
        dto.setParticipantType(null);

        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new ContractParticipant(dto)
        );

        Assertions.assertEquals("O tipo de participante não pode ser nulo.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenIdentificationDocumentIsNull() {
        // Arrange
        dto.setIdentificationDocument(null);

        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new ContractParticipant(dto)
        );

        Assertions.assertEquals("O documento de identificação não pode ser nulo.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenContactIsNull() {
        // Arrange
        dto.setContact(null);

        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new ContractParticipant(dto)
        );

        Assertions.assertEquals("As informações de contato não podem ser nulas.", exception.getMessage());
    }
}
