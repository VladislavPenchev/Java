package fdmc.web.servlets;

import fdmc.domain.entities.Cat;
import fdmc.util.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet("/cats/profile")
public class CatProfileServlet extends HttpServlet {

    private final static String CAT_PROFILE_HTML_FILE_PATH = "D:\\BackUp\\Java\\Java_Web_Development_Basics\\10.EXERCISE_INTRODUCTION_TO_JAVA_EE\\Projects\\First_From_Video\\src\\main\\resources\\views\\cat-profile.html";

    private final HtmlReader htmlReader;

    @Inject
    public CatProfileServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat = ((Map<String, Cat>)req.getSession().getAttribute("cats"))
                .get(req.getQueryString().split("=")[1]);

        String htmlFileContent = "";
        if(cat == null) {
            htmlFileContent = this.htmlReader
                    .readHtmlFile("D:\\BackUp\\Java\\Java_Web_Development_Basics\\10.EXERCISE_INTRODUCTION_TO_JAVA_EE\\Projects\\First_From_Video\\src\\main\\resources\\views\\non-existent-cat.html")
                    .replace("{{catName}}", req.getQueryString().split("=")[1]);
        } else {
            htmlFileContent = this.htmlReader.readHtmlFile(CAT_PROFILE_HTML_FILE_PATH)
                    .replace("{{catName}}", cat.getName())
                    .replace("{{catBreed}}", cat.getBreed())
                    .replace("{{catColor}}", cat.getColor())
                    .replace("{{catAge}}", String.valueOf(cat.getAge()));
        }

        resp.getWriter().println(htmlFileContent);
    }
}
