package login_management.service;

import login_management.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> findById(int id);

    List<User> findAll();

    User findByUsername(String name);
}
