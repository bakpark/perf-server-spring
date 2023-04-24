package bob.service;

import bob.dto.CreateEntranceRequest;
import bob.model.EntranceEntity;
import bob.repository.EntranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntranceService {
    private final EntranceRepository entranceRepository;

    public EntranceEntity createEntrance(CreateEntranceRequest request) {
        EntranceEntity entrance = new EntranceEntity(request.getRoomId(), request.getUserId());
        return entranceRepository.save(entrance);
    }

    public List<String> getRoomsUserInvolved(String userId, int limit) {
        return entranceRepository.findAllByUserIdOrderByCreatedAtDesc(userId, Pageable.ofSize(limit))
                .stream()
                .map(EntranceEntity::getRoomId)
                .collect(Collectors.toList());
    }
}
