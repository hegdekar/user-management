package dev.hegdekar.usermanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Set;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */
@Entity
public class Environment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String url;

  @OneToOne
  private Account account;

  @ManyToMany
  private Set<Capability> capabilities;

  public Environment() {
  }

  public Environment(Long id, String name, String url, Account account, Set<Capability> capabilities) {
    this.id = id;
    this.name = name;
    this.url = url;
    this.account = account;
    this.capabilities = capabilities;
  }

  public Long getId() {
    return id;
  }

  public Environment setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Environment setName(String name) {
    this.name = name;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public Environment setUrl(String url) {
    this.url = url;
    return this;
  }

  public Account getAccount() {
    return account;
  }

  public Environment setAccount(Account account) {
    this.account = account;
    return this;
  }

  public Set<Capability> getCapabilities() {
    return capabilities;
  }

  public Environment setCapabilities(Set<Capability> capabilities) {
    this.capabilities = capabilities;
    return this;
  }
}
