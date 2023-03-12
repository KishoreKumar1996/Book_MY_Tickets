package Book_My_Application.Home.DTOs;

import Book_My_Application.Home.Enums.ShowType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class ShowDTOs {
    private LocalDate localDate;

    private LocalTime localTime;

    private ShowType showType;

    private int movieId;

    private int theaterId;

    private int classicSeatPrice;

    private int premiumSeatPrice;
//    private LocalDate showDate;
//    private LocalTime showTime; //customize purpose
//
//    @Enumerated(value = EnumType.STRING)
//    private ShowType showType;
//    @CreationTimestamp
//    private Date createOn;
//    @CreationTimestamp
//    private Date updatedOn;

}
