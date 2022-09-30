package login_management.service.impl;

import login_management.model.User;
import login_management.repository.IUserRepository;
import login_management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Optional<User> findById(int id) {
        return iUserRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User findByUsername(String name) {
        return iUserRepository.findByUsername(name);
    }
}
