package bob.controller;

import bob.dto.ChatsResponse;
import bob.dto.CreateChatRequest;
import bob.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/api/chats")
    public String createChat(@RequestBody CreateChatRequest request) {
        chatService.createChat(request);
        return "";
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
