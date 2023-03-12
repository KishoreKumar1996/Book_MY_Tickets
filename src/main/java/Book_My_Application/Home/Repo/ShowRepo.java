package Book_My_Application.Home.Repo;

import Book_My_Application.Home.Entity.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepo extends JpaRepository<ShowEntity,Integer> {
}
