package dev.hegdekar.usermanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String firstName;

  private String middleName;

  private String lastName;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @ManyToMany
  private Set<Account> account;

  @ManyToMany
  private Set<Role> roles;

  @ManyToMany
  private Set<Environment> environments;

  @OneToOne
  private Environment defaultEnvironment;

  private String otp;
  private LocalDateTime otpGenerationTime;

  @Column(columnDefinition = "BIT(1) NOT NULL DEFAULT 1")
  private boolean isActive;

  @Column(columnDefinition = "BIT(1) NOT NULL DEFAULT 0")
  private boolean hasLoggedIn;

  public User() {
  }

  public User(Long id, String username, String firstName, String middleName, String lastName, String email,
              String password, Set<Account> account, Set<Role> roles, Set<Environment> environments,
              Environment defaultEnvironment, String otp, LocalDateTime otpGenerationTime,
              boolean isActive, boolean hasLoggedIn) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.account = account;
    this.roles = roles;
    this.environments = environments;
    this.defaultEnvironment = defaultEnvironment;
    this.otp = otp;
    this.otpGenerationTime = otpGenerationTime;
    this.isActive = isActive;
    this.hasLoggedIn = hasLoggedIn;
  }

  public Long getId() {
    return id;
  }

  public User setId(Long id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public User setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getMiddleName() {
    return middleName;
  }

  public User setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public User setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public Set<Account> getAccount() {
    return account;
  }

  public User setAccount(Set<Account> account) {
    this.account = account;
    return this;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public User setRoles(Set<Role> roles) {
    this.roles = roles;
    return this;
  }

  public Set<Environment> getEnvironments() {
    return environments;
  }

  public User setEnvironments(Set<Environment> environments) {
    this.environments = environments;
    return this;
  }

  public Environment getDefaultEnvironment() {
    return defaultEnvironment;
  }

  public User setDefaultEnvironment(Environment defaultEnvironment) {
    this.defaultEnvironment = defaultEnvironment;
    return this;
  }

  public String getOtp() {
    return otp;
  }

  public User setOtp(String otp) {
    this.otp = otp;
    return this;
  }

  public LocalDateTime getOtpGenerationTime() {
    return otpGenerationTime;
  }

  public User setOtpGenerationTime(LocalDateTime otpGenerationTime) {
    this.otpGenerationTime = otpGenerationTime;
    return this;
  }

  public boolean isActive() {
    return isActive;
  }

  public User setActive(boolean active) {
    isActive = active;
    return this;
  }

  public boolean isHasLoggedIn() {
    return hasLoggedIn;
  }

  public User setHasLoggedIn(boolean hasLoggedIn) {
    this.hasLoggedIn = hasLoggedIn;
    return this;
  }
}
