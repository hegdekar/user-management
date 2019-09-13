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
import java.util.Objects;
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

  @ManyToMany
  private Set<User> users;

  public Group() {
  }

  public Group(Long id, String name, User createdBy, LocalDateTime createdDate, Account account, Set<Role> roles,
               Set<Environment> environments, Set<User> users) {
    this.id = id;
    this.name = name;
    this.createdBy = createdBy;
    this.createdDate = createdDate;
    this.account = account;
    this.roles = roles;
    this.environments = environments;
    this.users = users;
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

  public Set<User> getUsers() {
    return users;
  }

  public Group setUsers(Set<User> users) {
    this.users = users;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Group group = (Group) o;
    return id.equals(group.id) &&
      name.equals(group.name) &&
      createdBy.equals(group.createdBy) &&
      createdDate.equals(group.createdDate) &&
      account.equals(group.account) &&
      Objects.equals(roles, group.roles) &&
      Objects.equals(environments, group.environments) &&
      Objects.equals(users, group.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, createdBy, createdDate, account, roles, environments, users);
  }

  @Override
  public String toString() {
    return "Group{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", createdBy=" + createdBy +
      ", createdDate=" + createdDate +
      ", account=" + account +
      ", roles=" + roles +
      ", environments=" + environments +
      ", users=" + users +
      '}';
  }
}
