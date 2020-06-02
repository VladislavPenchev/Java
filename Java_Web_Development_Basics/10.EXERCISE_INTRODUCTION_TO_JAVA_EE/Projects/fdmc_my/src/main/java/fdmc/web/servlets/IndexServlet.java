package fdmc.web.servlets;

import fdmc.web.Utils.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    private final static String HOME_CAT_HTML_FILE_PATH = "C:\\Users\\vladislav.penchev\\Desktop\\Java_Web_Development_Basics\\10.EXERCISE_INTRODUCTION_TO_JAVA_EE\\Projects\\fdmc_my\\src\\main\\resources\\views\\index.html";

    private final HtmlReader htmlReader;

    @Inject
    public IndexServlet(HtmlReader htmlReader){
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(this.htmlReader.readHtmlFile(HOME_CAT_HTML_FILE_PATH));
    }
}
