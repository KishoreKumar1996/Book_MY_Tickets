package Book_My_Application.Home.Entity;

import Book_My_Application.Home.Enums.Genre;
import Book_My_Application.Home.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Movie")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(unique = true,nullable = false)
    private String movieName;

    @Enumerated(value=EnumType.STRING)
    private Genre genre;

    private double rating;
    @Enumerated(value=EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "movieEntity",cascade = CascadeType.ALL)
    private List<ShowEntity> shows=new ArrayList<>();
}
