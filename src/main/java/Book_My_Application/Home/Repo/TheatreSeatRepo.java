package Book_My_Application.Home.Repo;

import Book_My_Application.Home.Entity.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepo extends JpaRepository<TheatreSeatEntity,Integer> {
}
