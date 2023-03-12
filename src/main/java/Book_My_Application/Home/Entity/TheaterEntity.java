package Book_My_Application.Home.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Theatre_Detail")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String TheatreName;
    private String Location;
    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<TheatreSeatEntity> theatreSeatEntityList=new ArrayList<>();

    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<ShowEntity> numberOfShow=new ArrayList<>();


}
