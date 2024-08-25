package kit.org.app.controller;

import kit.org.app.dto.link.LinkCreate;
import kit.org.app.dto.link.LinkShow;
import kit.org.app.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    @GetMapping("{userId}/links")
    public ResponseEntity<List<LinkShow>> getAllLinksByID(@PathVariable Long userId) {
        List<LinkShow> links = linkService.getAllById(userId);
        return ResponseEntity
                .ok()
                .header("X-Total-Count", String.valueOf(links.size()))
                .body(links);
    }

    @PostMapping("{userId}/links/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody LinkCreate link) {
        linkService.saveByUserId(link);
    }
}
