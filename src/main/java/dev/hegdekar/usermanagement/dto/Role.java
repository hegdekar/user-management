package dev.hegdekar.usermanagement.dto;

import dev.hegdekar.usermanagement.enums.RoleType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */
@Entity
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private String description;

  @Column(nullable = false)
  private RoleType type;

  @ManyToMany
  private Set<Capability> capabilities;

  public Role() {
  }

  public Role(Long id, String name, String description, RoleType type, Set<Capability> capabilities) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.type = type;
    this.capabilities = capabilities;
  }

  public Long getId() {
    return id;
  }

  public Role setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Role setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Role setDescription(String description) {
    this.description = description;
    return this;
  }

  public RoleType getType() {
    return type;
  }

  public Role setType(RoleType type) {
    this.type = type;
    return this;
  }

  public Set<Capability> getCapabilities() {
    return capabilities;
  }

  public Role setCapabilities(Set<Capability> capabilities) {
    this.capabilities = capabilities;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Role role = (Role) o;
    return id.equals(role.id) &&
      name.equals(role.name) &&
      Objects.equals(description, role.description) &&
      type == role.type &&
      Objects.equals(capabilities, role.capabilities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, type, capabilities);
  }

  @Override
  public String toString() {
    return "Role{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", description='" + description + '\'' +
      ", type=" + type +
      ", capabilities=" + capabilities +
      '}';
  }
}
