package com.nttdata.api.personacliente.repository;

import com.nttdata.api.personacliente.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
