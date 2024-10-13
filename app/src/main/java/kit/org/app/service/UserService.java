package kit.org.app.service;

import jakarta.transaction.Transactional;
import kit.org.app.dto.user.UserCreate;
import kit.org.app.dto.user.UserShow;
import kit.org.app.mapper.UserMapper;
import kit.org.app.model.User;
import kit.org.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public List<UserShow> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toShowUser)
                .toList();
    }

    @Transactional
    public UserShow getById(Long id) {
        return userMapper.toShowUser(userRepository.findById(id).orElseThrow());
    }

    public void save(UserCreate user) {
        userRepository.save(userMapper.toUser(user));
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
