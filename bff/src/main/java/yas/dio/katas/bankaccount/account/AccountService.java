package yas.dio.katas.bankaccount.account;

public interface AccountService {

    /**
     * Get the account balance for given id<br/>
     * If account not found throws {@link AccountNotFoundException}
     *
     * @param id Account id
     * @return Current account balance
     */
    double getBalance(Long id);

    /**
     * Make a deposit to given account Id
     *
     * @param id     Account id to receive the amount
     * @param amount Deposit value
     */
    void deposit(Long id, double amount);
}
