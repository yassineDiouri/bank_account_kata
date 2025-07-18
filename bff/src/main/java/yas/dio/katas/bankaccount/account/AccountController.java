package yas.dio.katas.bankaccount.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yas.dio.katas.bankaccount.statement.StatementDTO;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public StatementDTO getStatement(@PathVariable final Long id) {
        return accountService.getStatement(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void deposit(@PathVariable final Long id, @RequestBody final String amount) {
        if (null == amount || amount.isEmpty()) {
            throw new IllegalArgumentException("Amount is null or empty");
        }
        accountService.deposit(id, Double.parseDouble(amount));
    }

    @PostMapping(value = "/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void withdraw(@PathVariable final Long id, @RequestBody final String amount) {
        if (null == amount || amount.isEmpty()) {
            throw new IllegalArgumentException("Amount is null or empty");
        }
        accountService.withdraw(id, Double.parseDouble(amount));
    }
}
