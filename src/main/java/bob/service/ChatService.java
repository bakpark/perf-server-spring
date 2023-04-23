package bob.service;

import bob.dto.CreateChatRequest;
import bob.model.ChatEntity;
import bob.repository.ChatRepository;
import bob.repository.ChatRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatRepositoryCustom chatRepositoryCustom;


    public ChatEntity createChat(@RequestBody CreateChatRequest request) {
        return chatRepository.save(new ChatEntity(
                request.getMessage(),
                request.getSenderId(),
                request.getRoomId()
        ));
    }

    public List<String> getMessagesUserReceived(String userId, int limit) {
        return chatRepositoryCustom.
                findAllChatsUserReceived(userId, limit)
                .stream()
                .map(ChatEntity::getMessage)
                .collect(Collectors.toList());
    }


    public List<String> getMessagesInTheRoom(String roomId, int limit) {
        return chatRepository.
                findAllByRoomIdOrderByCreatedAtDesc(roomId, Pageable.ofSize(limit))
                .stream()
                .map(ChatEntity::getMessage)
                .collect(Collectors.toList());
    }
}
