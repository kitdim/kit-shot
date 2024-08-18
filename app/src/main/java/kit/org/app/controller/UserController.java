package kit.org.app.controller;

import kit.org.app.dto.user.UserCreate;
import kit.org.app.dto.user.UserShow;
import kit.org.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "api/users/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(path = "")
    public ResponseEntity<List<UserShow>> index() {
        List<UserShow> users = userService.getAll();
        return ResponseEntity
                .ok()
                .header("X-Total-Count", String.valueOf(users.size()))
                .body(users);
    }

    @PostMapping(path = "")
    public UserCreate save(@RequestBody UserCreate user) {
        userService.save(user);
        return user;
    }
}
