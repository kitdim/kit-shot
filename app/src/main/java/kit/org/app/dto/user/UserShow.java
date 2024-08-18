package kit.org.app.dto.user;

import kit.org.app.dto.link.LinkShow;

import java.util.List;

public record UserShow(Long id, String name, List<LinkShow> links) {
}
