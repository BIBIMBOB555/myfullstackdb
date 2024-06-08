package com.example.demo;


import lombok.*;


@AllArgsConstructor  @NoArgsConstructor
@Getter @Setter @ToString
public class MovieDTO {
    private long idx;
    private String title;
    private String image;
    private String content;
    
    public MovieDTO(Movie movie) {
        idx = movie.getIdx();
        title = movie.getTitle();
        image = movie.getImage();
        content = movie.getContent();
    }
}
