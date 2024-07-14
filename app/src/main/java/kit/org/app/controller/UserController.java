package kit.org.app.controller;

import kit.org.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "api/users/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}
