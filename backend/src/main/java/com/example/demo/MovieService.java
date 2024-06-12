package com.example.demo;

import java.util.List;

public interface MovieService {
    List<MovieDTO> list();
    public MovieDTO findById(long id);

    MovieDTO addMovie(MovieDTO movieDTO);
    MovieDTO updateMovie(long id, MovieDTO updatedMovieDTO);
    void deleteMovie(long id);
    

}
