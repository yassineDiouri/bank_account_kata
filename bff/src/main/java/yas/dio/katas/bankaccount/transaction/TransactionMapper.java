package yas.dio.katas.bankaccount.transaction;

import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionDTO toDTO(Transaction entity) {
        if (entity == null) {
            return null;
        }
        return TransactionDTO.builder()
                .date(entity.getDate())
                .amount(entity.getAmount())
                .balance(entity.getBalance())
                .build();
    }
}
