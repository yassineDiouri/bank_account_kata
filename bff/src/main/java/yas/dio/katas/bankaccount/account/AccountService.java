package yas.dio.katas.bankaccount.account;

import yas.dio.katas.bankaccount.statement.StatementDTO;

public interface AccountService {

    /**
     * Get the account balance for given id<br/>
     * If account not found throws {@link AccountNotFoundException}
     *
     * @param id Account id
     * @return Account balance
     */
    double getBalance(Long id);

    /**
     * Get the account statement for given id<br/>
     * If account not found throws {@link AccountNotFoundException}
     *
     * @param id Account id
     * @return Account statement
     */
    StatementDTO getStatement(Long id);

    /**
     * Make a deposit to given account Id<br/>
     * If account not found throws {@link AccountNotFoundException}<br/>
     * Else if amount <= 0 throws {@link IllegalArgumentException}
     *
     * @param id     Account id to receive the amount
     * @param amount Deposit value
     */
    void deposit(Long id, double amount);

    /**
     * Make a withdrawal from given account Id<br/>
     * If account not found throws {@link AccountNotFoundException}<br/>
     * Else if amount <= 0 throws {@link IllegalArgumentException}
     *
     * @param id     Account id to retrieve the amount from
     * @param amount Withdrawal value
     */
    void withdraw(Long id, double amount);
}
