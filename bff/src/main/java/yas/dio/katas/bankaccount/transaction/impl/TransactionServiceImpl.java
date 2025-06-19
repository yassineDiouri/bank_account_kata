package yas.dio.katas.bankaccount.transaction.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yas.dio.katas.bankaccount.account.Account;
import yas.dio.katas.bankaccount.transaction.Transaction;
import yas.dio.katas.bankaccount.transaction.TransactionDTO;
import yas.dio.katas.bankaccount.transaction.TransactionRepository;
import yas.dio.katas.bankaccount.transaction.TransactionService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    @Transactional
    public void save(final Account account, final double amount) {
        assertAccountNotNull(account);
        assertAmountNotEqualsToZero(amount);
        transactionRepository.save(
                Transaction.builder()
                        .date(LocalDateTime.now())
                        .amount(amount)
                        .balance(account.getBalance())
                        .account(account)
                        .build()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransactionDTO> getByAccountIdOrderByDateDesc(final Long accountId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void assertAccountNotNull(final Account account) {
        if (account == null) {
            throw new IllegalStateException("Account could not be null");
        }
    }

    private void assertAmountNotEqualsToZero(final double amount) {
        if (amount == 0) {
            throw new IllegalStateException("Amount could not be zero");
        }
    }
}
