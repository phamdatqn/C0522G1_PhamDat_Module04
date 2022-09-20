package validate_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import validate_management.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
