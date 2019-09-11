package dev.hegdekar.usermanagement.repositories;

import dev.hegdekar.usermanagement.dto.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Naveenkumar Hegdekar
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
