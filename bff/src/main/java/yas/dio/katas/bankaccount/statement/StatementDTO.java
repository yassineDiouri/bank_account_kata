package yas.dio.katas.bankaccount.statement;

import lombok.Builder;
import lombok.Data;
import yas.dio.katas.bankaccount.transaction.TransactionDTO;

import java.util.List;

@Data
@Builder
public class StatementDTO {
    private double balance;
    private List<TransactionDTO> transactions;
}
