package yas.dio.katas.bankaccount.transaction.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import yas.dio.katas.bankaccount.account.Account;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Nested
    class Save {
        @Test
        void should_call_repository_save() {
            //given
            when(transactionRepository.save(any(Transaction.class))).thenReturn(new Transaction());
            //when
            transactionService.save(new Account(), 100d);
            //then
            verify(transactionRepository).save(any(Transaction.class));
        }

        @Test
        void should_throws_IllegalStateException_when_account_null() {
            //given
            //when
            Executable actual = () -> transactionService.save(null, 100d);
            //then
            assertThrows(IllegalStateException.class, actual);
        }

        @Test
        void should_throws_IllegalStateException_when_amount_is_zero() {
            //given
            //when
            Executable actual = () -> transactionService.save(new Account(), 0);
            //then
            assertThrows(IllegalStateException.class, actual);
        }
    }
}