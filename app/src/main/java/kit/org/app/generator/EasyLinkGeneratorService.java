package kit.org.app.generator;

import java.util.Random;

public class EasyLinkGeneratorService implements Generator {
    @Override
    public String createShortLink() {
        return "http://localhost:8080/" + getValue();
    }
    private String getValue() {
        Random random = new Random();
        return String.valueOf(random.nextInt());
    }
}
