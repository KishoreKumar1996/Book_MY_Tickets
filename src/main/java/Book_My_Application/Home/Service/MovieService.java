package Book_My_Application.Home.Service;

import Book_My_Application.Home.Conventor.MovieConventor;
import Book_My_Application.Home.DTOs.MovieDTOs;
import Book_My_Application.Home.Entity.MovieEntity;
import Book_My_Application.Home.Repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public MovieEntity addMovie(MovieDTOs movieDTOs){
        //passing the parameter for convention by using without object creation
        MovieEntity movieEntity= MovieConventor.movieDtoIntoEntity(movieDTOs);
        //save the object to the repository
        movieRepo.save(movieEntity);
        return movieEntity;
    }
}
