package dev.hegdekar.usermanagement.controllers;

import dev.hegdekar.usermanagement.repositories.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Naveenkumar Hegdekar
 */
@Controller
public class AccountController {
  private AccountRepository accountRepository;

  public AccountController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @RequestMapping("/accounts")
  public String getUsers(Model model) {
    model.addAttribute("accounts", accountRepository.findAll());
    return "accounts";
  }
}
