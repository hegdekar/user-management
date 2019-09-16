package dev.hegdekar.usermanagement.repositories;

import dev.hegdekar.usermanagement.dto.Group;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Naveenkumar Hegdekar
 */
public interface GroupRepository extends CrudRepository<Group, Long> {
}
