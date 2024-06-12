package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


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




    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = new Movie(movieDTO);
        return new MovieDTO(repository.save(movie));
    }

    @Override
    public MovieDTO updateMovie(long id, MovieDTO updatedMovieDTO) {
        Optional<Movie> optionalMovie = repository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setTitle(updatedMovieDTO.getTitle());
            movie.setImage(updatedMovieDTO.getImage());
            movie.setContent(updatedMovieDTO.getContent());
            repository.save(movie); // 변경사항 저장
        return new MovieDTO(movie);
        } else {
        return null;
    }
}

    @Override
    public void deleteMovie(long id) {
        repository.deleteById(id);
    }
}
