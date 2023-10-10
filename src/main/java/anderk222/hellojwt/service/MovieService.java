package anderk222.hellojwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import anderk222.hellojwt.model.Movie;
import anderk222.hellojwt.repository.MovieRepository;

@Service
public class MovieService {
    
    @Autowired
    MovieRepository repository;


    public List<Movie> findAll(){

        Sort sort = Sort.by(Sort.Direction.ASC, "name");

        return repository.findAll(sort);
        
    }

}
