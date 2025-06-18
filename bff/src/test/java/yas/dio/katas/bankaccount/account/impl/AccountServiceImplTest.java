package yas.dio.katas.bankaccount.account.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import yas.dio.katas.bankaccount.account.Account;
import yas.dio.katas.bankaccount.account.AccountNotFoundException;
import yas.dio.katas.bankaccount.account.AccountRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Nested
    class GetBalance {
        @Test
        void should_return_account_balance_when_found() {
            //given
            when(accountRepository.findById(anyLong())).thenReturn(Optional.of(buildAccount(100d)));
            //when
            final double actual = accountService.getBalance(1L);
            //then
            assertEquals(100d, actual);
        }

        @Test
        void should_return_throws_AccountNotFoundException_when_not_found() {
            //given
            when(accountRepository.findById(anyLong())).thenReturn(Optional.empty());
            //when
            Executable actual = () -> accountService.getBalance(1L);
            //then
            assertThrows(AccountNotFoundException.class, actual);
        }
    }

    private static Account buildAccount(double balance) {
        final Account account = new Account();
        account.setBalance(balance);
        return account;
    }
}