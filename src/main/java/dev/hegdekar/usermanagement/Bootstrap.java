package dev.hegdekar.usermanagement;

import dev.hegdekar.usermanagement.dto.User;
import dev.hegdekar.usermanagement.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */
@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private UserRepository userRepository;

  public Bootstrap(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    createSuperAdmin();
  }
  
  /**
   * Creates the Super user in the database
   */
  private void createSuperAdmin(){
    User superAdmin = new User()
      .setFirstName("Naveenkumar")
      .setLastName("Hegdekar")
      .setEmail("hegdekar93@gmail.com")
      .setUsername("superAdmin")
      .setPassword("PaSsWoRd");
    userRepository.save(superAdmin);
  }
}
