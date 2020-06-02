package metube.web.filters;

import metube.domain.models.binding.TubeUploadBindingModel;
import metube.domain.models.binding.UserLoginBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/tube/upload")
public class TubeUploadFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if(req.getMethod().toLowerCase().equals("post")){
            TubeUploadBindingModel tubeUploadBindingModel = new TubeUploadBindingModel();
            tubeUploadBindingModel.setTitle(req.getParameter("title"));
            tubeUploadBindingModel.setAuthor(req.getParameter("author"));
            tubeUploadBindingModel.setYoutubeLink(req.getParameter("youtube-link"));
            tubeUploadBindingModel.setDescription(req.getParameter("description"));
            tubeUploadBindingModel.setUploader((String) req.getSession().getAttribute("username"));

            req.setAttribute("model", tubeUploadBindingModel);
        }

        filterChain.doFilter(req, resp);
    }
}
