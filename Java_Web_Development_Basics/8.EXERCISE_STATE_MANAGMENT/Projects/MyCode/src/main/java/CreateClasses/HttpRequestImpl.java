package CreateClasses;

import java.util.ArrayList;
import java.util.List;

public class HttpRequestImpl implements HttpRequest{

    private List<HttpCookie> cookies;

    public HttpRequestImpl(String request){
        this.init(request);
    }

    private void init(String request) {
        this.cookies = new ArrayList<>();
    }

    @Override
    public List<HttpCookie> getCookies() {
        return this.cookies;
    }

    @Override
    public void addCookies(HttpCookie cookie) {
        this.cookies.add(cookie);
    }
}
