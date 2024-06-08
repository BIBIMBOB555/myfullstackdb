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
}
