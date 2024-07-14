package kit.org.app.controller;

import kit.org.app.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "api/link/")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;
}
