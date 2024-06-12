package com.example.demo;


import jakarta.persistence.*;
import lombok.*;


@Getter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;
    private String title;
    private String image;
    private String content;



    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Movie(MovieDTO movieDTO) {
        this.title = movieDTO.getTitle();
        this.image = movieDTO.getImage();
        this.content = movieDTO.getContent();
    

    }
}
