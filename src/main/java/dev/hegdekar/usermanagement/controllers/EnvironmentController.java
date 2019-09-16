package dev.hegdekar.usermanagement.controllers;

import dev.hegdekar.usermanagement.repositories.EnvironmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */

@Controller
public class EnvironmentController {

  private EnvironmentRepository environmentRepository;

  public EnvironmentController(EnvironmentRepository environmentRepository) {
    this.environmentRepository = environmentRepository;
  }

  @RequestMapping("/environments")
  public String getEnvironments(Model model) {
    model.addAttribute("environments", environmentRepository.findAll());
    return "environments";
  }
}
