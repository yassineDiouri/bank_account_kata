package yas.dio.katas.bankaccount.transaction;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionDTO {
    private LocalDateTime date;
    private double amount;
    private double balance;
}
