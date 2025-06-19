package yas.dio.katas.bankaccount.transaction;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionDTO {
    private double amount;
    private LocalDateTime date;
}
