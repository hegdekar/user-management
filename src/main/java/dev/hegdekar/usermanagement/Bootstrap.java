package dev.hegdekar.usermanagement;

import dev.hegdekar.usermanagement.dto.Account;
import dev.hegdekar.usermanagement.dto.Capability;
import dev.hegdekar.usermanagement.dto.Environment;
import dev.hegdekar.usermanagement.dto.Role;
import dev.hegdekar.usermanagement.dto.User;
import dev.hegdekar.usermanagement.enums.CapabilityType;
import dev.hegdekar.usermanagement.enums.RoleType;
import dev.hegdekar.usermanagement.repositories.AccountRepository;
import dev.hegdekar.usermanagement.repositories.CapabilityRepository;
import dev.hegdekar.usermanagement.repositories.EnvironmentRepository;
import dev.hegdekar.usermanagement.repositories.GroupRepository;
import dev.hegdekar.usermanagement.repositories.RoleRepository;
import dev.hegdekar.usermanagement.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */
@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AccountRepository accountRepository;
  private CapabilityRepository capabilityRepository;
  private EnvironmentRepository environmentRepository;
  private GroupRepository groupRepository;
  private RoleRepository roleRepository;
  private UserRepository userRepository;

  Iterable<Capability> capabilities;

  public Bootstrap(AccountRepository accountRepository, CapabilityRepository capabilityRepository,
                   EnvironmentRepository environmentRepository, GroupRepository groupRepository,
                   RoleRepository roleRepository, UserRepository userRepository) {
    this.accountRepository = accountRepository;
    this.capabilityRepository = capabilityRepository;
    this.environmentRepository = environmentRepository;
    this.groupRepository = groupRepository;
    this.roleRepository = roleRepository;
    this.userRepository = userRepository;
    capabilities = capabilityRepository.findAll();

  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    try {
      if (!userRepository.findById(1L).isPresent()) {
        createSuperAdmin();
        createCapabilities();
        createRoles();
        createAccount();
        createEnvironments();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates the Super user in the database
   */
  private void createSuperAdmin() {
    User superAdmin = new User()
      .setFirstName("Naveenkumar")
      .setLastName("Hegdekar")
      .setEmail("hegdekar93@gmail.com")
      .setUsername("superAdmin")
      .setPassword("PaSsWoRd");
    userRepository.save(superAdmin);
  }

  private void createCapabilities() {
    Set<Capability> capabilities = new HashSet<>();
    Capability createUser = new Capability()
      .setDescription("Create users in Application")
      .setName("Create User")
      .setType(CapabilityType.APPLICATION);
    capabilities.add(createUser);

    Capability readUser = new Capability()
      .setDescription("Read users in Application")
      .setName("Read User")
      .setType(CapabilityType.APPLICATION);
    capabilities.add(readUser);

    Capability editUser = new Capability()
      .setDescription("Edit users in Application")
      .setName("Edit User")
      .setType(CapabilityType.APPLICATION);
    capabilities.add(editUser);

    Capability deleteUser = new Capability()
      .setDescription("Delete users in Application")
      .setName("Delete User")
      .setType(CapabilityType.APPLICATION);
    capabilities.add(deleteUser);

    Capability createEnv = new Capability()
      .setDescription("Create a new Environment under an account")
      .setName("Create Environment")
      .setType(CapabilityType.APPLICATION);
    capabilities.add(createEnv);
    Capability readEnv = new Capability()
      .setDescription("Read details of the Environment under an account")
      .setName("Read Environment")
      .setType(CapabilityType.APPLICATION);
    capabilities.add(readEnv);
    Capability updateEnvironment = new Capability()
      .setDescription("Update an existing Environment under an account")
      .setName("Update Environment")
      .setType(CapabilityType.APPLICATION);
    capabilities.add(updateEnvironment);

    Capability deleteEnv = new Capability()
      .setDescription("Delete an Environment under an account")
      .setName("Delete Environment")
      .setType(CapabilityType.APPLICATION);
    capabilities.add(deleteEnv);

    Capability createFlow = new Capability()
      .setDescription("Create a flow in an Environment")
      .setName("Create Flow")
      .setType(CapabilityType.ENVIRONMENT);
    capabilities.add(createFlow);

    Capability readFlow = new Capability()
      .setDescription("Read flows in an Environment")
      .setName("Read Flow")
      .setType(CapabilityType.ENVIRONMENT);
    capabilities.add(readFlow);

    Capability updateFlow = new Capability()
      .setDescription("Update flows in an Environment")
      .setName("Update Flow")
      .setType(CapabilityType.ENVIRONMENT);
    capabilities.add(updateFlow);

    Capability deleteFlow = new Capability()
      .setDescription("Delete flows in an Environment")
      .setName("Delete Flow")
      .setType(CapabilityType.ENVIRONMENT);
    capabilities.add(deleteFlow);

    Capability deployFlow = new Capability()
      .setDescription("Deploy flows in an Environment")
      .setName("Deploy Flow")
      .setType(CapabilityType.ENVIRONMENT);
    capabilities.add(deployFlow);
    capabilityRepository.saveAll(capabilities);
  }

  private void createRoles() {
    Set<Capability> capabilitySet = new HashSet<>();
    capabilities.forEach(capabilitySet::add);

    Role adminRole = new Role()
      .setDescription("User CRUD operations role")
      .setName("User Administrator")
      .setType(RoleType.APPLICATION)
      .setCapabilities(capabilitySet);

    roleRepository.save(adminRole);
  }

  private void createAccount() {
    Account account = new Account()
      .setAccountOwnerEmail("sunil_mm@thbs.com")
      .setAccountOwnerName("Sunil MM")
      .setName("THBS-CoE")
      .setCreatedDate(LocalDateTime.now())
      .setCreatedBy(userRepository.findById(1L).get());
    accountRepository.save(account);

    Set<Account> accounts = new HashSet<>();
    accounts.add(account);

    User adminUser = new User()
      .setUsername("naveen")
      .setEmail("naveenkumar_hegdekar@thbs.com")
      .setFirstName("Naveenkumar")
      .setLastName("Hegdekar")
      .setPassword("PaSsWoRd")
      .setAccount(accounts);
    userRepository.save(adminUser);
  }

  private void createEnvironments() {
    Set<Capability> environmentCapabilities = new HashSet<>();
    capabilities.forEach(capability -> {
      if (capability.getType().equals(CapabilityType.ENVIRONMENT)) {
        environmentCapabilities.add(capability);
      }
    });

    Set<Environment> environments = new HashSet<>();
    Environment devEnvironment = new Environment()
      .setAccount(accountRepository.findById(1L).get())
      .setName("Development Environment")
      .setUrl("http://localhost:4042")
      .setCapabilities(environmentCapabilities);
    environments.add(devEnvironment);

    Environment testEnv = new Environment()
      .setAccount(accountRepository.findById(1L).get())
      .setName("TestEnvironment")
      .setUrl("http://localhost:4044")
      .setCapabilities(environmentCapabilities);
    environments.add(testEnv);

    environmentRepository.saveAll(environments);
  }
}
