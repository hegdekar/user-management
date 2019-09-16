package dev.hegdekar.usermanagement.controllers;

import dev.hegdekar.usermanagement.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Naveenkumar Hegdekar
 */
@Controller
public class UserController {

  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping("/users")
  public String getUsers(Model model) {
    model.addAttribute("users", userRepository.findAll());
    return "users";
  }

  @RequestMapping("/usersLight")
  public String getUsersLight(Model model) {
    model.addAttribute("users", userRepository.findAll());
    return "user-light";
  }
}
