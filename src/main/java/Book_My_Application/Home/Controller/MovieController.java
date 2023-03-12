package Book_My_Application.Home.Controller;

import Book_My_Application.Home.DTOs.MovieDTOs;
import Book_My_Application.Home.Entity.MovieEntity;
import Book_My_Application.Home.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping("/movie-Add")
    public String movie(@RequestBody() MovieDTOs movieDTOs){
        movieService.addMovie(movieDTOs);
        return "successfully added";
    }
}
