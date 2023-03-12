package Book_My_Application.Home.Service;

import Book_My_Application.Home.Conventor.TicketConventor;
import Book_My_Application.Home.DTOs.TicketDTOs;
import Book_My_Application.Home.Entity.ShowEntity;
import Book_My_Application.Home.Entity.ShowSeatEntity;
import Book_My_Application.Home.Entity.TicketEntity;
import Book_My_Application.Home.Entity.UserEntity;
import Book_My_Application.Home.Repo.ShowRepo;
import Book_My_Application.Home.Repo.TicketRepo;
import Book_My_Application.Home.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {


    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    ShowRepo showRepo;

    @Autowired
    UserRepo userRepo;

  //  @Autowired
   // JavaMailSender javaMailSender;

    public String addTicket(TicketDTOs ticketDTOs) throws Exception{


        //1. Create TicketEntity from entryDto : Convert DTO ---> Entity
        TicketEntity ticketEntity = TicketConventor.convertEntryToEntity(ticketDTOs);


        //Validation : Check if the requested seats are available or not ?
        boolean isValidRequest = checkValidityofRequestedSeats(ticketDTOs);

        if(isValidRequest==false){
            throw new Exception("Requested seats are not available");
        }

        //We assume that the requestedSeats are valid


        //Calculate the total amount :
        ShowEntity showEntity = showRepo.findById(ticketDTOs.getShowId()).get();
        List<ShowSeatEntity> seatEntityList = showEntity.getShowSeatEntityList();
        List<String> requestedSeats = ticketDTOs.getRequestedSeats();

        int totalAmount = 0;
        for(ShowSeatEntity showSeatEntity:seatEntityList){

            if(requestedSeats.contains(showSeatEntity.getSeatNo())){
                totalAmount = totalAmount + showSeatEntity.getPrice();
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
            }
        }

        ticketEntity.setTotalAmount(totalAmount);


        //Setting the other attributes for the ticketEntity
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setShowDate(showEntity.getShowDate().toString());
        //ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setShowTime(showEntity.getShowTime().toString());
        ticketEntity.setTheatreName(showEntity.getTheaterEntity().getTheatreName());


        //We need to set that string that talked about requested Seats
        String allotedSeats = getAllotedSeatsfromShowSeats(requestedSeats);
        ticketEntity.setBookedSeats(allotedSeats);

        //Setting the foreign key attributes
        UserEntity userEntity = userRepo.findById(ticketDTOs.getUserId()).get();

        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        //Save the parent
        ticketEntity = ticketRepo.save(ticketEntity);


        List<TicketEntity> ticketEntityList = showEntity.getListOfBookedTickets();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfBookedTickets(ticketEntityList);

        showRepo.save(showEntity);


        List<TicketEntity> ticketEntityList1 = userEntity.getBookedTicked();
        ticketEntityList1.add(ticketEntity);
        userEntity.setBookedTicked(ticketEntityList1);

        userRepo.save(userEntity);


        String body = "Hi this is to confirm your booking for seat No "+allotedSeats +"for the movie : " + ticketEntity.getMovieName();


//        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
//        mimeMessageHelper.setFrom("kishorem11259@gmail.com");
//        mimeMessageHelper.setTo(userEntity.getEmail());
//        mimeMessageHelper.setText(body);
//        mimeMessageHelper.setSubject("Confirming your booked Ticket");
//
//        javaMailSender.send(mimeMessage);


        return "Ticket has successfully been added";

    }

    private String getAllotedSeatsfromShowSeats(List<String> requestedSeats){

        String result = "";

        for(String seat :requestedSeats){

            result = result + seat +", ";

        }
        return result;

    }


    private boolean checkValidityofRequestedSeats(TicketDTOs ticketDTOs){

        int showId = ticketDTOs.getShowId();

        List<String> requestedSeats = ticketDTOs.getRequestedSeats();

        ShowEntity showEntity = showRepo.findById(showId).get();

        List<ShowSeatEntity> listOfSeats = showEntity.getShowSeatEntityList();

        //Iterating over the list Of Seats for that particular show
        for(ShowSeatEntity showSeatEntity : listOfSeats){

            String seatNo = showSeatEntity.getSeatNo();

            if(requestedSeats.contains(seatNo)){

                if(showSeatEntity.isBooked()==true){
                    return false; //Since this seat cant be occupied : returning false
                }
            }
        }
        //All the seats requested were available
        return true;

    }
}
