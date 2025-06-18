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
}
