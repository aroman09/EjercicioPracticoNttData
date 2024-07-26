package com.nttdata.api.personacliente.service;

import com.nttdata.api.personacliente.model.dto.ClientDto;

import java.util.List;
import java.util.Map;


public interface ClientService {
    ClientDto createClient(ClientDto clienteDTO);
    List<ClientDto> listallClient();
    ClientDto retrieveClient(String id);
    ClientDto updateClient(ClientDto clienteDTO);
    ClientDto updateParameterClient(String id, Map<String, Object> parameters);
    void deleteClient(String id);
}
