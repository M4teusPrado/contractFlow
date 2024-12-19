package com.attus.contractFlow.controller;

import com.attus.contractFlow.dto.request.contract.CreateContractEventDTO;
import com.attus.contractFlow.dto.request.contract.CreateContractParticipantDTO;
import com.attus.contractFlow.dto.request.contract.CreateContractRequestDTO;
import com.attus.contractFlow.dto.response.CreateContractResponseDTO;
import com.attus.contractFlow.modal.contract.enums.EventType;
import com.attus.contractFlow.modal.contract.enums.ParticipantType;
import com.attus.contractFlow.modal.contract.valueobject.Contact;
import com.attus.contractFlow.modal.contract.valueobject.IdentificationDocument;
import com.attus.contractFlow.service.ContractCreationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ContractControllerTest {

    CreateContractRequestDTO request;
    @Mock
    private ContractCreationService contractCreationService;
    @InjectMocks
    private ContractController contractController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(contractController).build();
        objectMapper = new ObjectMapper();

        request = new CreateContractRequestDTO();
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


        request.setDescription("Contrato de Teste");
        request.setRecord(createContractEventDTO);
        request.setParticipants(createContractParticipantDTOList);
    }


    @Test
    void shouldCreateContractSuccessfully() throws Exception {
        // Arrange
        CreateContractResponseDTO response = new CreateContractResponseDTO(1);
        when(contractCreationService.createContract(request)).thenReturn(response);

        // Act & Assert
        mockMvc.perform(post("/api/contrato/criar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.contractId").value(1))
                .andExpect(jsonPath("$.message").value("Contract created successfully"));

        verify(contractCreationService, times(1)).createContract(request);
    }
}
