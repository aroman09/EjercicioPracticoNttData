package com.nttdata.api.personacliente.service.RabbitMQ;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.api.personacliente.model.dto.ClientDto;
import com.nttdata.api.personacliente.model.entity.Client;
import com.nttdata.api.personacliente.repository.ClientRepository;
import com.nttdata.api.personacliente.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class ClienteRequestConsumerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ClientService clienteService; // Servicio para acceder a la base de datos de clientes

    @Autowired
    private ObjectMapper objectMapper;
    private ClienteResponseProducerService clienteResponseService;

    @RabbitListener(queues = RabbitMQConfig.CLIENTE_REQUEST_QUEUE)
    public void receiveClienteRequest(String clienteId) {
        System.out.println("Solicitud recibida para el cliente ID: " + clienteId);

        try {
            ClientDto cliente = clienteService.retrieveClient(clienteId); // Obtener el cliente desde la base de datos

            String clienteJson = objectMapper.writeValueAsString(cliente);
            clienteResponseService.sendClienteResponse(clienteJson);
                ///clienteResponseService.sendClienteResponse(clienteJson);
                // Enviar la respuesta a la cola de respuesta
                //rabbitTemplate.convertAndSend(RabbitMQConfig.CLIENTE_RESPONSE_QUEUE, clienteJson);
            System.out.println("Cliente encontrado y enviado a la cola de respuesta: " + clienteJson);
        } catch (Exception e) {
            clienteResponseService.sendClienteResponse("");
            System.out.println("Error al procesar el cliente ID: " + e.getLocalizedMessage());
        }
    }
}

