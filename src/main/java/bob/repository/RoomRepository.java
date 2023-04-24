package bob.repository;

import bob.model.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, String> {
    @Transactional
    int deleteByRoomId(String roomId);
}
