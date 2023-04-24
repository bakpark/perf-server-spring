package bob.controller;

import bob.dto.CreateEntranceRequest;
import bob.dto.RoomsResponse;
import bob.service.EntranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EntranceController {

    private final EntranceService entranceService;

    @PostMapping("/api/entrances")
    public ResponseEntity createEntrance(@RequestBody CreateEntranceRequest request){
        entranceService.createEntrance(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/users/{userId}/rooms")
    public RoomsResponse getRoomsUserInvolved(
            @PathVariable("userId") String userId,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ){
        return new RoomsResponse(entranceService.getRoomsUserInvolved(userId, size));
    }

}
