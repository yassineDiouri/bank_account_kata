package yas.dio.katas.bankaccount.account;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(final Long id) {
        super("Account not found for id %d".formatted(id));
    }
}
