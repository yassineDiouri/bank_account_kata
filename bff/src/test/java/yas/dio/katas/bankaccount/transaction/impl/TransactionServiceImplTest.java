package yas.dio.katas.bankaccount.transaction.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import yas.dio.katas.bankaccount.account.Account;
import yas.dio.katas.bankaccount.transaction.Transaction;
import yas.dio.katas.bankaccount.transaction.TransactionDTO;
import yas.dio.katas.bankaccount.transaction.TransactionRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    class GetByAccountIdOrderByDateDesc {
        @Test
        void should_return_all_the_transactions_from_db() {
            //given
            //when
            final List<TransactionDTO> transactions = transactionService.getByAccountIdOrderByDateDesc(accountId);
            //then
            assertEquals(expectedSize, transactions.size());
        }

        @Test
        void should_return_zero_transaction_when_no_transactions_found_for_account_id() {
            //given
            //when
            final List<TransactionDTO> transactions = transactionService.getByAccountIdOrderByDateDesc(accountId);
            //then
            assertEquals(0, transactions.size());
        }

        @Test
        void should_return_transactions_ordered_by_date_desc() {
            //given
            //when
            final List<TransactionDTO> transactions = transactionService.getByAccountIdOrderByDateDesc(accountId);
            //then
            assertEquals(3, transactions.size());
            assertTrue(transactions.get(0).getDate().after(transactions.get(1).getDate()));
            assertTrue(transactions.get(1).getDate().after(transactions.get(2).getDate()));
        }
    }
}