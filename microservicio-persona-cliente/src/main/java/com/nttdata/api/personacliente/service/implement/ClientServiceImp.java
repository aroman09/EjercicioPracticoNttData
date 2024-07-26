package com.nttdata.api.personacliente.service.implement;

import com.nttdata.api.personacliente.excepcion.Error;
import com.nttdata.api.personacliente.manageObject.ClientMapper;
import com.nttdata.api.personacliente.model.dto.ClientDto;
import com.nttdata.api.personacliente.model.entity.Client;
import com.nttdata.api.personacliente.repository.ClientRepository;
import com.nttdata.api.personacliente.service.ClientService;
import com.nttdata.api.personacliente.manageObject.ProcessClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    ClientMapper clientMapper=new ClientMapper();


    @Override
    public ClientDto createClient(ClientDto clienteDTO) {
        if (clientRepository.findById(clienteDTO.getClientId()).isPresent())
            throw new Error("997");
        else{
            Client client = clientMapper.clientDTOToClient(clienteDTO);
            return clientMapper.clientToClientDTO(clientRepository.save(client));
        }
    }

    @Override
    public List<ClientDto> listallClient() {
        return clientRepository.findAll().stream()
                .map(clientMapper::clientToClientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto retrieveClient(String id) {
        return clientRepository.findById(id).map(clientMapper::clientToClientDTO)
                .orElseThrow(()-> new Error("996"));
    }

    @Override
    public ClientDto updateClient(ClientDto clienteDTO) {
        return clientRepository.findById(clienteDTO.getClientId())
                .map(cliente -> {
                    Client client = clientMapper.clientDTOToClient(clienteDTO);
                    return clientMapper.clientToClientDTO(clientRepository.save(client));
                })
        .orElseThrow(()-> new Error("996"));

    }

    @Override
    public ClientDto updateParameterClient(String id, Map<String, Object> parameters) {
        Client cliente = clientRepository.findById(id)
                .orElseThrow(() -> new Error("996"));
        ProcessClient processClient= new ProcessClient();
        return clientMapper.clientToClientDTO(clientRepository.save(processClient.updateClient(cliente,parameters)));
    }

    @Override
    public void deleteClient(String id) {
        if (!clientRepository.findById(id).isPresent())
            throw new Error("996");
        else clientRepository.deleteById(id);
    }
}
