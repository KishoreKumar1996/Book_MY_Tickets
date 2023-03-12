package Book_My_Application.Home.Entity;

import Book_My_Application.Home.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import java.util.Date;

@Entity
@Table(name="showSeat")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isBooked;

    private SeatType seatType;
    private int price;

    private String seatNo;
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    
}
