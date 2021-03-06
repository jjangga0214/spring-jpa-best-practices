package com.cheese.springjpa.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByEmail(com.cheese.springjpa.Account.model.Email email);
}
