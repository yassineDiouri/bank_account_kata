package yas.dio.katas.bankaccount.transaction.impl;

import org.springframework.stereotype.Service;
import yas.dio.katas.bankaccount.account.Account;
import yas.dio.katas.bankaccount.transaction.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public void save(Account account, double amount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
