package fdmc.web.servlets;

import fdmc.web.Utils.HtmlReader;
import fdmc.web.domain.entities.Cat;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/cats/all")
public class CatAllServlet extends HttpServlet {

    private final static String CAT_ALL_HTML_FILE_PATH = "C:\\Users\\vladislav.penchev\\Desktop\\Java_Web_Development_Basics\\10.EXERCISE_INTRODUCTION_TO_JAVA_EE\\Projects\\fdmc_my\\src\\main\\resources\\views\\cat-all.html";

    private final HtmlReader htmlReader;

    @Inject
    public CatAllServlet(HtmlReader htmlReader){
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlFileContent = this.htmlReader.readHtmlFile(CAT_ALL_HTML_FILE_PATH);

        if(req.getSession().getAttribute("cats") == null){
            htmlFileContent = htmlFileContent.replace("{{allCats}}", "There are no cats. <a href=\"/cats/create\">Create some.</a>");
        }else{

            StringBuilder aS = new StringBuilder();

            ((Map<String, Cat>)req.getSession().getAttribute("cats"))
                    .values()
                    .stream()
                    .forEach(cat -> aS.append(String.format("<a href=\"/cats/profile?catName=%s\">%s</a><br />", cat.getName(), cat.getName()))
                            .append(System.lineSeparator()));

            htmlFileContent = htmlFileContent.replace("{{allCats}}", aS.toString().trim());

        }

        resp.getWriter().println(htmlFileContent);
    }
}
