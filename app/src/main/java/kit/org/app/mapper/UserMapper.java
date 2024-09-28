package kit.org.app.mapper;

import kit.org.app.dto.user.UserCreate;
import kit.org.app.dto.user.UserShow;
import kit.org.app.model.User;
import kit.org.app.util.MapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {LinkMapper.class, MapperUtil.class})
public interface UserMapper {
    @Mapping(target = "password", qualifiedByName = {"MapperUtil", "getPasswordEncode"})
    User toUser(UserCreate dto);
    UserShow toShowUser(User model);
}
