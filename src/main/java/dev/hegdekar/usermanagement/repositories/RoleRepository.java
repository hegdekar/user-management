package dev.hegdekar.usermanagement.repositories;

import dev.hegdekar.usermanagement.dto.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Naveenkumar Hegdekar
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
