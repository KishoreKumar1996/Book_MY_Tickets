package Book_My_Application.Home.Service;

import Book_My_Application.Home.Conventor.MovieConventor;
import Book_My_Application.Home.Conventor.TheatreConventor;
import Book_My_Application.Home.DTOs.TheatreDTOs;
import Book_My_Application.Home.Entity.TheaterEntity;
import Book_My_Application.Home.Entity.TheatreSeatEntity;
import Book_My_Application.Home.Enums.SeatType;
import Book_My_Application.Home.Repo.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreRepo theatreRepo;
    @Autowired
    TheatreSeatEntity theatreSeatEntity;

    public String theatreMovies(TheatreDTOs theatreDTOs) {
        //transfer Dto into entity
        TheaterEntity theaterEntity = TheatreConventor.theaterConventIntoEntity(theatreDTOs);
        //we have to do book the seat by theater Entity so we pass the theaterDto and theaterEntity

        //By sending Dto taking the types of seat book
        List<TheatreSeatEntity> theatreSeatEntityList = createTheaterSeats(theatreDTOs, theaterEntity);
        //set the list of seatThreater entity
        theaterEntity.setTheatreSeatEntityList(theatreSeatEntityList);

        //save to repo theater
        theatreRepo.save(theaterEntity);
        return "Theater Added successfully";
    }

    private List<TheatreSeatEntity> createTheaterSeats(TheatreDTOs theatreDTOs, TheaterEntity theaterEntity) {
        List<TheatreSeatEntity> theatreSeatEntityList = new ArrayList<>();
        int noOfPremium = theatreDTOs.getNoOfPremiumSeat();
        int noOfClassic = theatreDTOs.getNoOfClassicSeat();

        for (int count = 1; count <= noOfClassic; count++) {
            TheatreSeatEntity theatreSeatEntity = TheatreSeatEntity.builder().
                    seatNo((count + "C")).seatType(SeatType.CLASSIC).
                    theaterEntity(theaterEntity).build();
            theatreSeatEntityList.add(theatreSeatEntity);
        }
        for (int count = 1; count <= noOfPremium; count++) {
            TheatreSeatEntity theatreSeatEntity = TheatreSeatEntity.builder().seatNo(count + "B").seatType(SeatType.PREMIUM).
                    theaterEntity(theaterEntity).build();
            theatreSeatEntityList.add(theatreSeatEntity);
        }
        return theatreSeatEntityList;
    }
}
