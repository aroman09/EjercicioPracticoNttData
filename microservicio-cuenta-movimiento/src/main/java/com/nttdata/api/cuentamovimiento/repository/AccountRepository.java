package com.nttdata.api.cuentamovimiento.repository;

import com.nttdata.api.cuentamovimiento.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findAllByIdCliente(String idCliente);
}
