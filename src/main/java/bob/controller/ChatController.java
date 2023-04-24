package bob.controller;

import bob.dto.ChatsResponse;
import bob.dto.CreateChatRequest;
import bob.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/api/chats")
    public ResponseEntity createChat(@RequestBody CreateChatRequest request) {
        chatService.createChat(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/users/{userId}/chats")
    public ChatsResponse getChatsUserReceived(
            @PathVariable("userId") String userId,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        return new ChatsResponse(chatService.getMessagesUserReceived(userId, size));
    }

    @GetMapping("/api/rooms/{roomId}/chats")
    public ChatsResponse getChatsInTheRoom(
            @PathVariable("roomId") String roomId,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        return new ChatsResponse(chatService.getMessagesInTheRoom(roomId, size));
    }
}
