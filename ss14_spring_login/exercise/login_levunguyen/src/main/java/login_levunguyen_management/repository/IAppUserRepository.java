package login_levunguyen_management.repository;

import login_levunguyen_management.entity.AppUser;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<User, Long> {
    AppUser findByUsername(String userName);
}
