package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieController {

    @Autowired private MovieService movieService;


    @RequestMapping("/movie")
    public List<MovieDTO> list() {
        return movieService.list();
    }

    @RequestMapping("/movie/{id}")
    public MovieDTO movie(@PathVariable long id) {
        return movieService.findById(id);
    }



    @PostMapping("/movie")
    public MovieDTO addMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.addMovie(movieDTO);
    }

    @PutMapping("/movie/{id}")
    public MovieDTO updateMovie(@PathVariable long id, @RequestBody MovieDTO movieDTO) {
        return movieService.updateMovie(id, movieDTO);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable long id) {
        movieService.deleteMovie(id);
    }

}
