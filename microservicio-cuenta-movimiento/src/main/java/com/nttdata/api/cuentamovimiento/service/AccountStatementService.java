package com.nttdata.api.cuentamovimiento.service;

import com.nttdata.api.cuentamovimiento.model.dto.AccountStatementDto;

import java.time.LocalDate;

public interface AccountStatementService {
    AccountStatementDto retrieveAccountStatement(LocalDate startDate, LocalDate endDate, String idClient);
}
