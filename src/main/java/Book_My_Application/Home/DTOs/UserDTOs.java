package Book_My_Application.Home.DTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDTOs {

    private String name;

    private String Email_Id;

    private int age;

    private String mobNo;

    private String address;
}
