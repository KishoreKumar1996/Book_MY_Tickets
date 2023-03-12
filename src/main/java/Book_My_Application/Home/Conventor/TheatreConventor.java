package Book_My_Application.Home.Conventor;

import Book_My_Application.Home.DTOs.TheatreDTOs;
import Book_My_Application.Home.Entity.TheaterEntity;

public class TheatreConventor {

    public static TheaterEntity theaterConventIntoEntity(TheatreDTOs theatreDTOs){
        TheaterEntity theaterEntity=TheaterEntity.builder().TheatreName(theatreDTOs.getTheatreName()).Location(theatreDTOs.getLocation())
                .build();
        return theaterEntity;
    }
}
