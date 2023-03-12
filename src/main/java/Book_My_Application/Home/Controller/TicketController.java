package Book_My_Application.Home.Controller;

import Book_My_Application.Home.DTOs.TicketDTOs;
import Book_My_Application.Home.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody TicketDTOs ticketDTOs){


        try{
            String result = ticketService.addTicket(ticketDTOs);
            return result;

        }catch (Exception e){

            return "ticket is been booked";
        }


    }
}
