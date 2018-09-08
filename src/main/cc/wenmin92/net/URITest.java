package cc.wenmin92.net;

import java.net.URI;
import java.net.URISyntaxException;

public class URITest {
    public static void main(String[] args) throws URISyntaxException {
        URI absolute = new URI("http", "//www.ibiblio.org", null);
        URI relative = new URI(null, "/javafaq/index.shtml", "[]{}:;'\"<,>.?/|\\中国");

        System.out.println(absolute);
        System.out.println(relative.toASCIIString());
        System.out.println(relative.getRawFragment());
        System.out.println(relative.getFragment());
        System.out.println(URI.create("abc").toASCIIString());
    }
}
