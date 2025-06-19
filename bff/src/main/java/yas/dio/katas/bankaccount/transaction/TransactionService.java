package yas.dio.katas.bankaccount.transaction;

import yas.dio.katas.bankaccount.account.Account;

public interface TransactionService {

    /**
     * Save new transaction using account info and the amount
     * If the amount is positive it's a deposit else it's a withdrawal
     *
     * @param account The concerned account by transaction
     * @param amount  the amount of the transaction (could be positive or negative)
     */
    void save(final Account account, final double amount);
}
