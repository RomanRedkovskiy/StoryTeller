package com.example.storyteller.dto.requestDto;

import com.example.storyteller.model.Creator;
import com.example.storyteller.model.Post;
import com.example.storyteller.model.StoryMarker;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class StoryRequestTo {

    private String title;

    private String context;

    private String created;

    private String modified;

    private Long creatorId;

}
