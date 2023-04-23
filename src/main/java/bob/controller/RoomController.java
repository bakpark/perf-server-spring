package bob.controller;

import bob.dto.CreateRoomRequest;
import bob.service.RoomService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/api/rooms")
    public String createRoom(CreateRoomRequest request) {
        roomService.createRoom(request);
        return "";
    }

    @DeleteMapping("/api/rooms/{roomId}")
    public String deleteRoom(@PathVariable String roomId) {
        roomService.deleteRoomByRoomId(roomId);
        return "";
    }
}
