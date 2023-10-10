package anderk222.hellojwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anderk222.hellojwt.model.Movie;
import anderk222.hellojwt.service.MovieService;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MovieController {
    
    @Autowired 
    MovieService service;

    @GetMapping()
    public List<Movie> findAll(){

        return service.findAll();
    }

}
