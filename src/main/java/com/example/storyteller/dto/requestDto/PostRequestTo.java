package com.example.storyteller.dto.requestDto;

import com.example.storyteller.model.Story;
import lombok.Data;

@Data
public class PostRequestTo {

    private String context;

    private Long storyId;
}