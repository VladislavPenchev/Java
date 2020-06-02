package metube.web.servlets;

import metube.domain.models.binding.TubeUploadBindingModel;
import metube.domain.models.service.TubeServiceModel;
import metube.service.TubeService;
import metube.util.Mapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tube/upload")
public class TubeUploadServlet extends HttpServlet {

    private final TubeService tubeService;
    private final Mapper mapper;

    @Inject
    public TubeUploadServlet(TubeService tubeService, Mapper mapper) {
        this.tubeService = tubeService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TubeUploadBindingModel tubeUploadBindingModel = (TubeUploadBindingModel) req.getAttribute("model");

        TubeServiceModel tubeServiceModel = this.mapper.map(tubeUploadBindingModel, TubeServiceModel.class);


    }
}
