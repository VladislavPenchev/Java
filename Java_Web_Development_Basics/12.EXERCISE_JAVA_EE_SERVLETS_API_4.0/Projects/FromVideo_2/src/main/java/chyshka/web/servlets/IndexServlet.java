package chyshka.web.servlets;

import chyshka.domain.models.view.AllProductsViewModel;
import chyshka.service.ProductService;
import chyshka.util.HtmlReader;
import chyshka.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private final static String INDEX_HTML_FILE_PATH = "C:\\Users\\vladislav.penchev\\Desktop\\Java_Web_Development_Basics\\12.EXERCISE_JAVA_EE_SERVLETS_API_4.0\\Projects\\FromVideo_2\\src\\main\\resources\\views\\Index.html";

    private final ProductService productService;
    private final HtmlReader htmlReader;
    private final ModelMapper modelMapper;

    @Inject
    public IndexServlet(ProductService productService, HtmlReader htmlReader, ModelMapper modelMapper) {
        this.productService = productService;
        this.htmlReader = htmlReader;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlFileContent = this.htmlReader.readHtmlFile(INDEX_HTML_FILE_PATH)
                .replace("{{listItems}}", this.formatListItems());

        resp.getWriter().println(htmlFileContent);
    }

    private String formatListItems(){
        List<AllProductsViewModel> allProducts = this.productService
                .findAllProducts()
                .stream()
                .map(productServiceModel -> this.modelMapper.map(productServiceModel, AllProductsViewModel.class))
                .collect(Collectors.toList());

        StringBuilder listItems = new StringBuilder();

        allProducts.forEach(product ->{
            listItems.append(String.format("<li><a href=\"/products/details?name=%s\">%s</li>", product.getName(), product.getName()))
            .append(System.lineSeparator());
        });

        return listItems.toString().trim();

    }

}
