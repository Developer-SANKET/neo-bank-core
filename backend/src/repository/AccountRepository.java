package com.neobank.core.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.neobank.core.entity.Account;
public interface AccountRepository extends JpaRepository<Account, Long> {}
