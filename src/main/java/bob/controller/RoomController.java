package bob.controller;

import bob.dto.CreateRoomRequest;
import bob.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/api/rooms")
    public ResponseEntity createRoom(@RequestBody CreateRoomRequest request) {
        roomService.createRoom(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/api/rooms/{roomId}")
    public ResponseEntity deleteRoom(@PathVariable String roomId) {
        roomService.deleteRoomByRoomId(roomId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
