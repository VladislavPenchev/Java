package CreateClasses;

import java.util.List;

public interface HttpRequest {

    List<HttpCookie> getCookies();

    void addCookies(HttpCookie cookie);
}
