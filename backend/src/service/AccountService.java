package com.neobank.core.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neobank.core.entity.Account;
import com.neobank.core.repository.AccountRepository;
@Service
public class AccountService {
  private final AccountRepository repo;
  public AccountService(AccountRepository repo) { this.repo = repo; }
  @Transactional
  public Account credit(Long id, Double amount) {
    Account acc = repo.findById(id).orElseThrow();
    acc.setBalance(acc.getBalance() + amount);
    return repo.save(acc);
  }
  @Transactional
  public Account debit(Long id, Double amount) {
    Account acc = repo.findById(id).orElseThrow();
    if (acc.getBalance() < amount) throw new RuntimeException("Insufficient balance");
    acc.setBalance(acc.getBalance() - amount);
    return repo.save(acc);
  }
  public Double balance(Long id) {
    return repo.findById(id).orElseThrow().getBalance();
  }
}
