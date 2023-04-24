package bob.service;

import bob.dto.CreateRoomRequest;
import bob.model.EntranceEntity;
import bob.model.RoomEntity;
import bob.repository.EntranceRepository;
import bob.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final EntranceRepository entranceRepository;

    public RoomEntity createRoom(CreateRoomRequest request) {
        String roomId = request.getRoomId();
        entranceRepository.saveAll(request.getUsers()
                .stream()
                .map((userId) -> new EntranceEntity(roomId, userId))
                .toList());
        return roomRepository.save(new RoomEntity(roomId));
    }

    public void deleteRoomByRoomId(String roomId) {
        roomRepository.deleteByRoomId(roomId);
    }
}
