package Book_My_Application.Home.DTOs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketDTOs {

        private int showId;

        private List<String> requestedSeats = new ArrayList<>();

        private int userId;
    }

