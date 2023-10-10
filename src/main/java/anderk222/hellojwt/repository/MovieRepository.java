package anderk222.hellojwt.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.hellojwt.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll(Sort sort);
    
}
