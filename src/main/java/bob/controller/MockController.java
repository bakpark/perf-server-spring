package bob.controller;

import bob.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class MockController {

    @PostMapping("/api/chats")
    public String postChat(@RequestBody CreateChatRequest createChatRequest) {
        return "";
    }

    @PostMapping("/api/rooms")
    public String postRoom(@RequestBody CreateRoomRequest createRoomRequest) {
        return "";
    }

    @DeleteMapping("/api/rooms/{roomId}")
    public String deleteRoom(@PathVariable("roomId") String roomId) {
        return "";
    }

    @PostMapping("/api/entrances")
    public String postEntrance(@RequestBody CreateEntranceRequest createEntranceRequest) {
        return "";
    }

    @PostMapping("/api/users")
    public String postUser(@RequestBody CreateUserRequest createUserRequest) {
        return "";
    }

    @DeleteMapping("/api/users/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        return "";
    }

    @GetMapping("/api/users/{userId}/rooms")
    public RoomsResponse getRoomsUserInvolved(@PathVariable("userId") String userId) {
        return RoomsResponse.empty();
    }

    @GetMapping("/api/users/{userId}/chats")
    public ChatsResponse getChatsUserReceived(@PathVariable("userId") String userId) {
        return ChatsResponse.empty();
    }

    @GetMapping("/api/rooms/{roomId}/chats")
    public ChatsResponse getChatsInTheRoom(@PathVariable("roomId") String roomId) {
        return ChatsResponse.empty();
    }
}
