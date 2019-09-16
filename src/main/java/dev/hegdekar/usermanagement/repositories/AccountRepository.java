package dev.hegdekar.usermanagement.repositories;

import dev.hegdekar.usermanagement.dto.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Naveenkumar Hegdekar
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
}
