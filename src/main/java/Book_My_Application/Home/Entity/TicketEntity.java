package Book_My_Application.Home.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="User_Tickets")
@Data
@NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int price;

    private String movieName;

    private String showTime;

    private String showDate;

    private String TicketId= UUID.randomUUID().toString();

    private String TheatreName;
    private int totalAmount;
    private String bookedSeats;
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

//    @OneToMany
//    @JoinColumn
//    private ShowEntity showEntity;

    //Ticket is child wrt to showEntity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
}
