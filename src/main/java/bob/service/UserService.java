package bob.service;

import bob.model.UserEntity;
import bob.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity createUser(String userId) {
        return userRepository.save(new UserEntity(userId));
    }

    public void deleteByUserId(String userId) {
        userRepository.deleteByUserId(userId);
    }
}
