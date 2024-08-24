package kit.org.app.mapper;

import kit.org.app.dto.link.LinkCreate;
import kit.org.app.dto.link.LinkShow;
import kit.org.app.model.Link;
import kit.org.app.util.LinkUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {LinkUtil.class})
public interface LinkMapper {
    @Mapping(target = "originalName", source = "name")
    @Mapping(target = "shortName", source = "userType", qualifiedByName = {"LinkUtil", "getShortName"})
    @Mapping(target = "user", source = "userId", qualifiedByName = {"LinkUtil", "getUserFromUtil"})
    Link toLink(LinkCreate dto);
    LinkShow toShowLink(Link link);
}
