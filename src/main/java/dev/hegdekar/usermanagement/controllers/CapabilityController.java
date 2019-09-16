package dev.hegdekar.usermanagement.controllers;

import dev.hegdekar.usermanagement.repositories.CapabilityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */
@Controller
public class CapabilityController {
  private CapabilityRepository capabilityRepository;

  public CapabilityController(CapabilityRepository capabilityRepository) {
    this.capabilityRepository = capabilityRepository;
  }

  @RequestMapping("/capabilities")
  public String getUsers(Model model) {
    model.addAttribute("capabilities", capabilityRepository.findAll());
    return "capabilities";
  }
}
