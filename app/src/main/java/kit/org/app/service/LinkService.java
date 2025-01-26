package kit.org.app.service;

import kit.org.app.dto.link.LinkCreate;
import kit.org.app.dto.link.LinkShow;
import kit.org.app.mapper.LinkMapper;
import kit.org.app.repository.LinkRepository;
import kit.org.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LinkService {
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;
    private final LinkMapper linkMapper;

    public List<LinkShow> getAllById(Long userId) {
      return linkRepository.findAllByUserId(userId).stream()
              .map(linkMapper::toShowLink)
              .toList();
    }

    public void saveByUserId(Long userId, LinkCreate linkCreate) {
        // todo подумать нужна ли тут проверка, и нужно ли для LinkCreate поле id
        if (userRepository.findById(userId).isEmpty() || !userId.equals(linkCreate.userId())) {
            throw new InvalidParameterException("Error in response or url");
        }
        linkRepository.save(linkMapper.toLink(linkCreate));
    }

    public String getFullUrl(String someShortUrl) {
        return linkRepository.findByShortName("http://localhost:8080/" + someShortUrl);
    }
}
