package bob.controller;

import bob.dto.CreateUserRequest;
import bob.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public String createUser(@RequestBody CreateUserRequest request) {
        userService.createUser(request.getUserId());
        return "";
    }

    @DeleteMapping("/api/users/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        userService.deleteByUserId(userId);
        return "";
    }
}
