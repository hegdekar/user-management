package dev.hegdekar.usermanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */
@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @OneToOne
  private User createdBy;

  @Column(nullable = false, unique = true)
  private String accountOwnerEmail;

  @Column(nullable = false)
  private String accountOwnerName;

  @Column(nullable = false)
  private LocalDateTime createdDate;

  @Column(nullable = false, columnDefinition = "BIT(1) NOT NULL DEFAULT 0")
  private boolean isDeleted;

  @Column(nullable = false, columnDefinition = "BIT(1) NOT NULL DEFAULT 1")
  private boolean isActive;

  public Account() {
  }

  public Account(Long id, String name, User createdBy, String accountOwnerEmail, String accountOwnerName,
                 LocalDateTime createdDate, boolean isDeleted, boolean isActive) {
    this.id = id;
    this.name = name;
    this.createdBy = createdBy;
    this.accountOwnerEmail = accountOwnerEmail;
    this.accountOwnerName = accountOwnerName;
    this.createdDate = createdDate;
    this.isDeleted = isDeleted;
    this.isActive = isActive;
  }

  public Long getId() {
    return id;
  }

  public Account setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Account setName(String name) {
    this.name = name;
    return this;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public Account setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public String getAccountOwnerEmail() {
    return accountOwnerEmail;
  }

  public Account setAccountOwnerEmail(String accountOwnerEmail) {
    this.accountOwnerEmail = accountOwnerEmail;
    return this;
  }

  public String getAccountOwnerName() {
    return accountOwnerName;
  }

  public Account setAccountOwnerName(String accountOwnerName) {
    this.accountOwnerName = accountOwnerName;
    return this;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public Account setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public Account setDeleted(boolean deleted) {
    isDeleted = deleted;
    return this;
  }

  public boolean isActive() {
    return isActive;
  }

  public Account setActive(boolean active) {
    isActive = active;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return isDeleted == account.isDeleted &&
      isActive == account.isActive &&
      id.equals(account.id) &&
      name.equals(account.name) &&
      createdBy.equals(account.createdBy) &&
      accountOwnerEmail.equals(account.accountOwnerEmail) &&
      accountOwnerName.equals(account.accountOwnerName) &&
      createdDate.equals(account.createdDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, createdBy, accountOwnerEmail, accountOwnerName, createdDate, isDeleted, isActive);
  }

  @Override
  public String toString() {
    return "Account{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", createdBy=" + createdBy +
      ", accountOwnerEmail='" + accountOwnerEmail + '\'' +
      ", accountOwnerName='" + accountOwnerName + '\'' +
      ", createdDate=" + createdDate +
      ", isDeleted=" + isDeleted +
      ", isActive=" + isActive +
      '}';
  }
}
