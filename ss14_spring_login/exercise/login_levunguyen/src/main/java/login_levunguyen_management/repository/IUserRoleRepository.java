package login_levunguyen_management.repository;

import login_levunguyen_management.entity.AppUser;
import login_levunguyen_management.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
