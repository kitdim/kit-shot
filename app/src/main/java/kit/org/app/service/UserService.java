package kit.org.app.service;

import jakarta.transaction.Transactional;
import kit.org.app.dto.user.UserCreate;
import kit.org.app.dto.user.UserShow;
import kit.org.app.mapper.UserMapper;
import kit.org.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public List<UserShow> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toShowUser)
                .toList();
    }

    public void save(UserCreate user) {
        userRepository.save(userMapper.toUser(user));
    }
}
