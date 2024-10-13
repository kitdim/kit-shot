package kit.org.app.mapper;

import kit.org.app.dto.link.LinkCreate;
import kit.org.app.dto.link.LinkShow;
import kit.org.app.model.Link;
import kit.org.app.util.MapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {MapperUtil.class})
public interface LinkMapper {
    @Mapping(target = "originalName", source = "name")
    @Mapping(target = "shortName", source = "userType", qualifiedByName = {"MapperUtil", "getShortName"})
    @Mapping(target = "user", source = "userId", qualifiedByName = {"MapperUtil", "getUserFromUtil"})
    Link toLink(LinkCreate dto);
    @Mapping(target = "name", source = "shortName")
    LinkShow toShowLink(Link link);
}
