package bob.controller;

import bob.dto.CreateEntranceRequest;
import bob.dto.RoomsResponse;
import bob.service.EntranceService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntranceController {

    private final EntranceService entranceService;

    public EntranceController(EntranceService entranceService) {
        this.entranceService = entranceService;
    }

    @PostMapping("/api/entrances")
    public String createEntrance(@RequestBody CreateEntranceRequest request){
        entranceService.createEntrance(request);
        return "";
    }

    @GetMapping("/api/users/{userId}/rooms")
    public RoomsResponse getRoomsUserInvolved(
            @PathVariable("userId") String userId,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ){
        return new RoomsResponse(entranceService.getRoomsUserInvolved(userId, size));
    }

}
