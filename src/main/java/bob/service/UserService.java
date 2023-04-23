package bob.service;

import bob.model.UserEntity;
import bob.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(String userId) {
        return userRepository.save(new UserEntity(userId));
    }

    public void deleteByUserId(String userId) {
        userRepository.deleteById(userId);
    }
}
