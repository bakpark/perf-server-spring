package bob.controller;

import bob.dto.CreateUserRequest;
import bob.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity createUser(@RequestBody CreateUserRequest request) {
        userService.createUser(request.getUserId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") String userId) {
        userService.deleteByUserId(userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
