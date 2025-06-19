package yas.dio.katas.bankaccount.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
@CrossOrigin
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public double getBalance(@PathVariable final Long id) {
        return accountService.getBalance(id);
    }

    @PutMapping("/{id}")
    public void deposit(@PathVariable final Long id, @RequestBody final double amount) {
        accountService.deposit(id, amount);
    }
}
