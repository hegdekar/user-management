package dev.hegdekar.usermanagement.controllers;

import dev.hegdekar.usermanagement.repositories.RoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */
@Controller
public class RoleController {

  private RoleRepository roleRepository;

  public RoleController(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @RequestMapping("/roles")
  public String getRoles(Model model) {
    model.addAttribute("roles", roleRepository.findAll());
    return "roles";
  }
}
