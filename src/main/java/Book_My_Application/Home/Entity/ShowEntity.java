package Book_My_Application.Home.Entity;

import Book_My_Application.Home.Enums.ShowType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Shows")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;
    private LocalTime showTime; //customize purpose

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;
    @CreationTimestamp
    private Date createOn;
    @CreationTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfBookedTickets = new ArrayList<>();

    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> showSeatEntityList=new ArrayList<>();
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;

    @ManyToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntityList=new ArrayList<>();
}
