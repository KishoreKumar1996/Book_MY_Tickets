package Book_My_Application.Home.Repo;

import Book_My_Application.Home.DTOs.MovieDTOs;
import Book_My_Application.Home.Entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity,Integer> {
}
