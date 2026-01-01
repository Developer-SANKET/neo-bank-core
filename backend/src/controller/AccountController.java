package com.neobank.core.controller;
import org.springframework.web.bind.annotation.*;
import com.neobank.core.service.AccountService;
import com.neobank.core.entity.Account;
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
  private final AccountService service;
  public AccountController(AccountService service) { this.service = service; }
  @PostMapping("/{id}/credit")
  public Account credit(@PathVariable Long id, @RequestParam Double amount) {
    return service.credit(id, amount);
  }
  @PostMapping("/{id}/debit")
  public Account debit(@PathVariable Long id, @RequestParam Double amount) {
    return service.debit(id, amount);
  }
  @GetMapping("/{id}/balance")
  public Double balance(@PathVariable Long id) {
    return service.balance(id);
  }
}
