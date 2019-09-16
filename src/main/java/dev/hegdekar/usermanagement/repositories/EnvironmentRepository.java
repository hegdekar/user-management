package dev.hegdekar.usermanagement.repositories;

import dev.hegdekar.usermanagement.dto.Environment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Naveenkumar Hegdekar
 */
public interface EnvironmentRepository extends CrudRepository<Environment, Long> {
}
