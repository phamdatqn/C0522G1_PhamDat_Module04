package validate_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import validate_management.model.User;

public interface IUserService {
    void save(User user);

    Page<User> findAll(Pageable pageable);
}
