package kit.org.app.mapper;

import kit.org.app.dto.user.UserCreate;
import kit.org.app.dto.user.UserShow;
import kit.org.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = LinkMapper.class)
public interface UserMapper {
    User toUser(UserCreate dto);
    UserShow toShowUser(User model);
}
