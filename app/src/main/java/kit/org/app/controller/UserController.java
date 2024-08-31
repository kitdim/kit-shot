package kit.org.app.controller;

import kit.org.app.dto.user.UserCreate;
import kit.org.app.dto.user.UserShow;
import kit.org.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/")
@RequiredArgsConstructor
public class  UserController {
    private final UserService userService;

    @GetMapping(path = "all")
    public ResponseEntity<List<UserShow>> index() {
        List<UserShow> users = userService.getAll();
        return ResponseEntity
                .ok()
                .header("X-Total-Count", String.valueOf(users.size()))
                .body(users);
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserShow getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreate save(@ModelAttribute UserCreate user) {
        userService.save(user);
        return user;
    }

    @PostMapping(path = "login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserShow login(@RequestBody String login) {
        return userService.findByName(login);
    }
}
