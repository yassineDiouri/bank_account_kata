package yas.dio.katas.bankaccount.account.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yas.dio.katas.bankaccount.account.Account;
import yas.dio.katas.bankaccount.account.AccountNotFoundException;
import yas.dio.katas.bankaccount.account.AccountRepository;
import yas.dio.katas.bankaccount.account.AccountService;
import yas.dio.katas.bankaccount.statement.StatementDTO;
import yas.dio.katas.bankaccount.transaction.TransactionService;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    @Override
    @Transactional(readOnly = true)
    public StatementDTO getStatement(final Long id) {
        return StatementDTO.builder()
                .balance(this.getBalance(id))
                .transactions(transactionService.getByAccountIdOrderByDateDesc(id))
                .build();
    }

    @Override
    @Transactional
    public void deposit(final Long id, final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        final Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
        account.setBalance(account.getBalance() + amount);
        transactionService.save(account, amount);
    }

    @Override
    @Transactional
    public void withdraw(Long id, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        final Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
        account.setBalance(account.getBalance() - amount);
        transactionService.save(account, -amount);
    }

    /**
     * Get the account balance for given id<br/>
     * If account not found throws {@link AccountNotFoundException}
     *
     * @param id Account id
     * @return Account balance
     */
    private double getBalance(final Long id) {
        return accountRepository.findById(id)
                .map(Account::getBalance)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }
}
