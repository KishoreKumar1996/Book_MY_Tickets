package Book_My_Application.Home.Conventor;

import Book_My_Application.Home.DTOs.MovieDTOs;
import Book_My_Application.Home.Entity.MovieEntity;

public class MovieConventor {

    public static MovieEntity movieDtoIntoEntity(MovieDTOs movieDTOs){
        MovieEntity movieEntity= MovieEntity.builder().movieName(movieDTOs.getMovieName()).genre(movieDTOs.getGenre()).language(movieDTOs.getLanguage()
                ).rating(movieDTOs.getRating()).build();
        return movieEntity;
    }
}
