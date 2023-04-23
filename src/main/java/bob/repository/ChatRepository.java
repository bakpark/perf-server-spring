package bob.repository;

import bob.model.ChatEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends CrudRepository<ChatEntity, String> {
    List<ChatEntity> findAllByRoomIdOrderByCreatedAtDesc(String roomId, Pageable pageable);
}
