package dev.hegdekar.usermanagement.repositories;

import dev.hegdekar.usermanagement.dto.Capability;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Naveenkumar Hegdekar
 */
public interface CapabilityRepository extends CrudRepository<Capability, Long> {
}
