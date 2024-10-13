package kit.org.app.util;

import kit.org.app.generator.GeneratorFactory;
import kit.org.app.model.User;
import kit.org.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Named("MapperUtil")
@Component
@RequiredArgsConstructor
public class MapperUtil {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Named("getUserFromUtil")
    public User getUserFromUtil(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Named("getShortName")
    public String getShortName(String userType) {
        return new GeneratorFactory().getKitLink(userType);
    }

    @Named("getPasswordEncode")
    public String getPasswordEncode(String password) {
        return passwordEncoder.encode(password);
    }
}
