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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/cats/create")
public class CatCreateServlet extends HttpServlet {
    private final static String CREATE_CAT_HTML_FILE_PATH = "C:\\Users\\vladislav.penchev\\Desktop\\Java_Web_Development_Basics\\10.EXERCISE_INTRODUCTION_TO_JAVA_EE\\Projects\\fdmc_my\\src\\main\\resources\\views\\cat-create.html";

    private final HtmlReader htmlReader;

    @Inject
    public CatCreateServlet(HtmlReader htmlReader){
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(this.htmlReader.readHtmlFile(CREATE_CAT_HTML_FILE_PATH));
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cat cat = new Cat();

        cat.setName(req.getParameter("name"));
        cat.setBreed(req.getParameter("breed"));
        cat.setColor(req.getParameter("color"));
        cat.setNumberOfLegs(Integer.parseInt(req.getParameter("numberOfLegs")));

        if(req.getSession().getAttribute("cats") == null){
            req.getSession().setAttribute("cats", new LinkedHashMap<>());
        }

        ((Map<String, Cat>)req.getSession().getAttribute("cats")).putIfAbsent(cat.getName(), cat);

        resp.sendRedirect(String.format("/cats/profile?catName=%s",cat.getName()));
    }
}
