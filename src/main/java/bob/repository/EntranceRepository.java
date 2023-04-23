package bob.repository;

import bob.model.EntranceEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntranceRepository extends CrudRepository<EntranceEntity, Long> {

    List<EntranceEntity> findAllByUserIdOrderByCreatedAtDesc(String userId, Pageable pageable);
}
