package com.nttdata.api.cuentamovimiento.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nttdata.api.cuentamovimiento.model.dto.AccountDto;

import java.util.List;
import java.util.concurrent.ExecutionException;


public interface AccountService {
    AccountDto createAccount(AccountDto AccounteDTO);
    List<AccountDto> listallAccount() throws ExecutionException, InterruptedException, JsonProcessingException;
    List<AccountDto> listAccountByClient(String idClient);
    AccountDto retrieveAccount(String id);
    AccountDto updateAccount(AccountDto AccounteDTO);
    void deleteAccount(String id);
    AccountDto retrieveAccountActive(String id);
}
