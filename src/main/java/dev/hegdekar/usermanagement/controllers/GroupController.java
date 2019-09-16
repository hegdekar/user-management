package dev.hegdekar.usermanagement.controllers;

import dev.hegdekar.usermanagement.repositories.GroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */
@Controller
public class GroupController {
  private GroupRepository groupRepository;

  public GroupController(GroupRepository groupRepository) {
    this.groupRepository = groupRepository;
  }

  @RequestMapping("/groups")
  public String getUsers(Model model) {
    model.addAttribute("groups", groupRepository.findAll());
    return "groups";
  }
}
