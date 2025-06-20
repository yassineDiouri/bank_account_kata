package yas.dio.katas.bankaccount.statement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import yas.dio.katas.bankaccount.transaction.TransactionDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatementDTO {
    private double balance;
    private List<TransactionDTO> transactions;
}
