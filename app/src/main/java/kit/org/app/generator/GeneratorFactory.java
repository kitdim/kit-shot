package kit.org.app.generator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneratorFactory {
    public String getKitLink(String typeUser) {
        Generator generator;
        String kitLink = "";
        if (typeUser.equals("easy")) {
            log.info("A user with a easy subscription came in for processing.");
            generator = new EasyLinkGeneratorService();
            kitLink = generator.createShortLink();
        } else {
            log.debug("The specified unit type is not specified.");
        }
        return kitLink;
    }
}
