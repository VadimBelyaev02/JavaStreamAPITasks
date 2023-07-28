package com.vadim.model;

import com.vadim.model.enums.Genre;
import lombok.Data;

import java.util.List;

@Data
public class Performer {

    private Long id;

    private String name;

    private Genre genre;

    private List<Song> songs;
}
