package yas.dio.katas.bankaccount.account.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yas.dio.katas.bankaccount.account.AccountNotFoundException;
import yas.dio.katas.bankaccount.account.AccountService;
import yas.dio.katas.bankaccount.account.Account;
import yas.dio.katas.bankaccount.account.AccountRepository;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public double getBalance(final Long id) {
        return accountRepository.findById(id)
                .map(Account::getBalance)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @Override
    @Transactional
    public void deposit(final Long id, final double amount) {
        final Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
        account.setBalance(account.getBalance() + amount);
    }
}
