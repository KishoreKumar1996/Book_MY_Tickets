package Book_My_Application.Home.Controller;

import Book_My_Application.Home.DTOs.TheatreDTOs;
import Book_My_Application.Home.Service.TheatreService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatres-seats")
public class TheatreController {

    @Autowired
    TheatreService theatreService;
    public String showingTheatre(@RequestBody()TheatreDTOs theatreDTOs){
        theatreService.theatreMovies(theatreDTOs);
        return "Booking success";
    }
}
