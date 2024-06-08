package com.example.demo;

import java.util.List;

public interface MovieService {
    List<MovieDTO> list();
    public MovieDTO findById(long id);

}
