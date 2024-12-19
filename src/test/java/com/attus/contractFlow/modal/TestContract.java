package com.attus.contractFlow.modal;


import com.attus.contractFlow.dto.request.contract.create.CreateContractEventDTO;
import com.attus.contractFlow.dto.request.contract.create.CreateContractParticipantDTO;
import com.attus.contractFlow.dto.request.contract.create.CreateContractRequestDTO;
import com.attus.contractFlow.modal.contract.entitys.Contract;
import com.attus.contractFlow.modal.contract.enums.ContractStatus;
import com.attus.contractFlow.modal.contract.enums.EventType;
import com.attus.contractFlow.modal.contract.enums.ParticipantType;
import com.attus.contractFlow.modal.contract.valueobject.Contact;
import com.attus.contractFlow.modal.contract.valueobject.IdentificationDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestContract {

    CreateContractRequestDTO contractDto;

    @BeforeEach
    void setUp() {

        contractDto = new CreateContractRequestDTO();

        CreateContractEventDTO createContractEventDTO = new CreateContractEventDTO();
        createContractEventDTO.setDescription("Evento Teste");
        createContractEventDTO.setEventType(EventType.ASSINATURA);

        List<CreateContractParticipantDTO> createContractParticipantDTOList = new ArrayList<>();

        CreateContractParticipantDTO createContractParticipantDTO = new CreateContractParticipantDTO();
        createContractParticipantDTO.setFullName("Jose do Prado");
        createContractParticipantDTO.setParticipantType(ParticipantType.ADVOGADO);

        Contact contact = new Contact();
        contact.setEmail("jose@gmail.com");
        contact.setPhone("(15)998047229");
        createContractParticipantDTO.setContact(contact);

        createContractParticipantDTOList.add(createContractParticipantDTO);

        IdentificationDocument document = new IdentificationDocument();
        document.setIdentification("46900619800");
        createContractParticipantDTO.setIdentificationDocument(document);


        contractDto.setDescription("Contrato de Teste");
        contractDto.setRecord(createContractEventDTO);
        contractDto.setParticipants(createContractParticipantDTOList);
    }


    @Test
    void shouldCreateContractSuccessfully() {
        // Arrange
            //@beforeEach

        // Act
        Contract contract = new Contract(contractDto);

        // Assert
        Assertions.assertNotNull(contract);
        Assertions.assertEquals("Contrato de Teste", contract.getDescription());
        Assertions.assertEquals(1, contract.getParties().size());
        Assertions.assertEquals(1, contract.getRecords().size());
        Assertions.assertEquals(ContractStatus.ACTIVE, contract.getStatus());
    }


    @Test
    void shouldThrowExceptionWhenDescriptionIsNull(){
        // Arrange

        contractDto.setDescription(null);

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contract(contractDto), "A descrição do contrato é obrigatória.");
    }


    @Test
    void shouldThrowExceptionWhenNoParticipants(){
        // Arrange
        contractDto.setParticipants(null);

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contract(contractDto), "O contrato deve ter pelo menos um participante.");
    }

    @Test
    void shouldThrowExceptionWhenNoRecords() {
        // Arrange
        contractDto.setRecord(null);

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contract(contractDto), "O contrato deve conter pelo menos um registro de evento.");
    }


    @Test
    void shouldThrowExceptionWhenDescriptionMoreThan255() {
        // Arrange
        String longDescription = "a".repeat(256);
        contractDto.setDescription(longDescription);

        // Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Contract(contractDto)
        );

        //Assert
        Assertions.assertEquals(
                "A descrição do contrato não pode exceder 255 caracteres.",
                exception.getMessage()
        );
    }

    @Test
    void shouldFillStatusWithActive() {
        // Act
        Contract contract = new Contract(contractDto);

        //Assert
        Assertions.assertEquals(contract.getStatus(), ContractStatus.ACTIVE);
    }
}
