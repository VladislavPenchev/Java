package softuni.realestate.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import softuni.realestate.Util.HtmlReader;
import softuni.realestate.domain.models.view.OfferViewModel;
import softuni.realestate.service.OfferService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final OfferService offerService;
    private final HtmlReader reader;
    private final ModelMapper modelMapper;

    public HomeController(OfferService offerService, HtmlReader reader, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.reader = reader;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    @ResponseBody
    public String index() throws IOException {
        return this.prepareHtml();
    }

    private String prepareHtml() throws IOException {
        List<OfferViewModel> offers = this.offerService.findAllOfferce()
                .stream()
                .map(o -> this.modelMapper.map(o, OfferViewModel.class))
                .collect(Collectors.toList());

        StringBuilder offersHtml = new StringBuilder();
        if(offers.size() == 0){
            offersHtml.append("<div class=\"apartment\" style=\"border: red solid 1px\">")
                    .append("There aren't any offers!")
                    .append("</div>");

            return this.reader
                    .readHtmlFile("D:\\BackUp\\Java\\Java_MVC_Frameworks_Spring\\04.EXERCISE_SPRING_BOOT_INTRODUCTION\\Projects\\Third_FromVideo\\src\\main\\resources\\static\\index.html")
                    .replace("{{offers}}", offersHtml.toString().trim());
        }

        for (OfferViewModel offer : offers) {
            offersHtml.append("<div class=\"apartment\">")
                    .append("<p>Rent: " + offer.getApartmentRent() + "</p>")
                    .append("<p>Type: " + offer.getApartmentType() + "</p>")
                    .append("<p>Commission: " + offer.getAgencyCommission() + "</p>")
                    .append("</div>")
                    .append(System.lineSeparator());
        }

        return this.reader
                .readHtmlFile("D:\\BackUp\\Java\\Java_MVC_Frameworks_Spring\\04.EXERCISE_SPRING_BOOT_INTRODUCTION\\Projects\\Third_FromVideo\\src\\main\\resources\\static\\index.html")
                .replace("{{offers}}", offersHtml.toString().trim());
    }

}
