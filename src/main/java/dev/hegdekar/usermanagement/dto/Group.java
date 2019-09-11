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
@Table(name = "groups")
public class Group {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToOne
  private User createdBy;

  @Column(nullable = false)
  private LocalDateTime createdDate;

  @OneToOne
  private Account account;

  @ManyToMany
  private Set<Role> roles;

  @ManyToMany
  private Set<Environment> environments;

  public Group() {
  }

  public Group(Long id, String name, User createdBy, LocalDateTime createdDate, Account account, Set<Role> roles,
               Set<Environment> environments) {
    this.id = id;
    this.name = name;
    this.createdBy = createdBy;
    this.createdDate = createdDate;
    this.account = account;
    this.roles = roles;
    this.environments = environments;
  }

  public Long getId() {
    return id;
  }

  public Group setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Group setName(String name) {
    this.name = name;
    return this;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public Group setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public Group setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public Account getAccount() {
    return account;
  }

  public Group setAccount(Account account) {
    this.account = account;
    return this;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public Group setRoles(Set<Role> roles) {
    this.roles = roles;
    return this;
  }

  public Set<Environment> getEnvironments() {
    return environments;
  }

  public Group setEnvironments(Set<Environment> environments) {
    this.environments = environments;
    return this;
  }
}
