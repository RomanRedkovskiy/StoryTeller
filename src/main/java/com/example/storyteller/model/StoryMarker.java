package com.example.storyteller.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_story_marker")
public class StoryMarker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Story story;

    @ManyToOne(fetch = FetchType.LAZY)
    private Marker marker;

}
