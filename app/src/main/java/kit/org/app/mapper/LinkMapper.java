package kit.org.app.mapper;

import kit.org.app.dto.link.LinkCreate;
import kit.org.app.dto.link.LinkShow;
import kit.org.app.model.Link;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LinkMapper {
    Link toLink(LinkCreate dto);
    LinkShow toShowLink(Link link);
}
