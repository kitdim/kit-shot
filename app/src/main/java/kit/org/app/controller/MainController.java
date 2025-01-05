package kit.org.app.controller;

import kit.org.app.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class MainController {
    private final LinkService linkService;

    @GetMapping("{someShortUrl}")
    @ResponseStatus(HttpStatus.OK)
    public String getFullUrl(@PathVariable String someShortUrl) {
        return linkService.getFullUrl(someShortUrl);
    }
}
