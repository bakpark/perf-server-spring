package bob.repository;

import bob.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
    @Transactional
    int deleteByUserId(String userId);
}
