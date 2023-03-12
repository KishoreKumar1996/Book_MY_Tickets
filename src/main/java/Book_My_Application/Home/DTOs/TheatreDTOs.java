package Book_My_Application.Home.DTOs;

import lombok.Data;

@Data
public class TheatreDTOs {
    private String TheatreName;
    private String Location;

    private int noOfClassicSeat;
    private int noOfPremiumSeat;
}
