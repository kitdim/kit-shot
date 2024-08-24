package kit.org.app.util;

import kit.org.app.generator.GeneratorFactory;
import kit.org.app.model.User;
import kit.org.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Named("LinkUtil")
@Component
@RequiredArgsConstructor
public class LinkUtil {
    private UserRepository userRepository;

    @Named("getUserFromUtil")
    public User getUserFromUtil(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Named("getShortName")
    public String getShortName(String userType) {
        return new GeneratorFactory().getKitLink(userType);
    }
}
