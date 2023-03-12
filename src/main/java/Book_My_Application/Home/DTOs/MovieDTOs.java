package Book_My_Application.Home.DTOs;

import Book_My_Application.Home.Enums.Genre;
import Book_My_Application.Home.Enums.Language;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MovieDTOs {

    private String movieName;


    private Genre genre;

    private double rating;

    private Language language;
}
