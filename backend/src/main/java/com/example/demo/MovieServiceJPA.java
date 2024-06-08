package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MovieServiceJPA implements MovieService{
    @Autowired
    private MovieRepository repository;

    @Override
    public List<MovieDTO> list() {
        return repository.findAll().stream().map(MovieDTO::new).collect(Collectors.toList());
    }

    @Override
    public MovieDTO findById(long idx) {
        return  new MovieDTO(repository.findById(idx).get());
    }


}
