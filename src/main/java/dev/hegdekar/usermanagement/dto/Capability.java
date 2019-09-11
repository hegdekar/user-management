package dev.hegdekar.usermanagement.dto;

import dev.hegdekar.usermanagement.enums.CapabilityType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Naveenkumar Hegdekar
 * @version 1.0.0
 */
@Entity
public class Capability {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String name;

  private String description;

  @Column(nullable = false)
  private CapabilityType type;

  public Capability() {
  }

  public Capability(long id, String name, String description, CapabilityType type) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.type = type;
  }

  public long getId() {
    return id;
  }

  public Capability setId(long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Capability setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Capability setDescription(String description) {
    this.description = description;
    return this;
  }

  public CapabilityType getType() {
    return type;
  }

  public Capability setType(CapabilityType type) {
    this.type = type;
    return this;
  }
}
