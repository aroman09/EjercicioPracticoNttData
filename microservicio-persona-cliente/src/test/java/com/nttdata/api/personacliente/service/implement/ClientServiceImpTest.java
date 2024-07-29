package com.nttdata.api.personacliente.service.implement;

import com.nttdata.api.personacliente.model.dto.ClientDto;
import com.nttdata.api.personacliente.model.entity.Client;
import com.nttdata.api.personacliente.model.entity.Person;
import com.nttdata.api.personacliente.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImpTest {

    @Mock
    private ClientRepository clienteRepository;

    @InjectMocks
    private ClientServiceImp clienteService;

    private Client cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Client();
        cliente.setPersona(new Person());
        cliente.setClientId("jperez");
        cliente.getPersona().setNombre("Juan Pérez");
    }

    @Test
    void retrieveClient() {
        when(clienteRepository.findById("jperez")).thenReturn(Optional.of(cliente));
        ClientDto resultado = clienteService.retrieveClient("jperez");
        assertEquals(cliente.getClientId(), resultado.getClientId());
    }
}