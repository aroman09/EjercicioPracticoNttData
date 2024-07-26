package com.nttdata.api.cuentamovimiento.service;

import com.nttdata.api.cuentamovimiento.model.dto.AccountDto;

import java.util.List;


public interface AccountService {
    AccountDto createAccount(AccountDto AccounteDTO);
    List<AccountDto> listallAccount();
    List<AccountDto> listAccountByClient(String idClient);
    AccountDto retrieveAccount(String id);
    AccountDto updateAccount(AccountDto AccounteDTO);
    void deleteAccount(String id);
    AccountDto retrieveAccountActive(String id);
}
