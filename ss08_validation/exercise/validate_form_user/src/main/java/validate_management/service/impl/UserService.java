package validate_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import validate_management.model.User;
import validate_management.repository.IUserRepository;
import validate_management.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }
}
