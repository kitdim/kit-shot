package kit.org.app.service;

import kit.org.app.dto.link.LinkCreate;
import kit.org.app.dto.link.LinkShow;
import kit.org.app.mapper.LinkMapper;
import kit.org.app.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository linkRepository;
    private final LinkMapper linkMapper;

    public List<LinkShow> getAllById(Long userId) {
      return linkRepository.findAllByUserId(userId).stream()
              .map(linkMapper::toShowLink)
              .toList();
    }

    public void saveByUserId(LinkCreate linkCreate) {
        linkRepository.save(linkMapper.toLink(linkCreate));
    }
}
