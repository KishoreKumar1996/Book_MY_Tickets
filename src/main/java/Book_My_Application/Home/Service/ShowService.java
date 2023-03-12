package Book_My_Application.Home.Service;

import Book_My_Application.Home.Conventor.ShowConventor;
import Book_My_Application.Home.DTOs.ShowDTOs;
import Book_My_Application.Home.Entity.*;
import Book_My_Application.Home.Enums.SeatType;
import Book_My_Application.Home.Repo.MovieRepo;
import Book_My_Application.Home.Repo.ShowRepo;
import Book_My_Application.Home.Repo.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepo showRepo;

    @Autowired
    TheatreRepo theatreRepo;
    @Autowired
    MovieRepo movieRepo;
    public ShowEntity showAdd(ShowDTOs showDTOs){
        ShowEntity showEntity= ShowConventor.convertShowDtoIntoEntity(showDTOs);

        int movieId=showDTOs.getMovieId();
        int theaterId=showDTOs.getTheaterId();

        List<ShowSeatEntity> showSeatEntityList= addingTheShoeSeat(showDTOs,showEntity);
        MovieEntity movieEntity = movieRepo.findById(movieId).get();
        TheaterEntity theaterEntity = theatreRepo.findById(theaterId).get();


        //Setting the attribute of foreignKe
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        //Pending attributes the listOfShowSeatsEnity

        List<ShowSeatEntity> seatEntityList = addingTheShoeSeat(showDTOs,showEntity);

        showEntity.setShowSeatEntityList(seatEntityList);


        //Now we  also need to update the parent entities


        showEntity = showRepo.save(showEntity);

        movieEntity.getShows().add(showEntity);
        theaterEntity.getNumberOfShow().add(showEntity); //getShowEntityList()


        movieRepo.save(movieEntity);

        theatreRepo.save(theaterEntity);

        return showEntity;

    }

    public List<ShowSeatEntity> addingTheShoeSeat(ShowDTOs showDTOs,ShowEntity showEntity){
        //Now the goal is to create the ShowSeatEntity
        //We need to set its attribute

        TheaterEntity theaterEntity = showEntity.getTheaterEntity();

        List<TheatreSeatEntity> theaterSeatEntityList = theaterEntity.getTheatreSeatEntityList();

        List<ShowSeatEntity> seatEntityList = new ArrayList<>();

        for(TheatreSeatEntity theatreSeatEntity : theaterSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theatreSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theatreSeatEntity.getSeatType());

            if(theatreSeatEntity.getSeatType().equals(SeatType.CLASSIC))
                showSeatEntity.setPrice(showDTOs.getClassicSeatPrice());

            else
                showSeatEntity.setPrice(showDTOs.getPremiumSeatPrice());

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity); //parent : foreign key for the showSeat Entity

            seatEntityList.add(showSeatEntity); //Adding it to the list
        }

        return  seatEntityList;

    }
}
