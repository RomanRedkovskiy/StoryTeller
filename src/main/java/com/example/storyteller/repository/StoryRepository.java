package com.example.storyteller.repository;

import com.example.storyteller.model.Story;
import org.springframework.data.repository.CrudRepository;

public interface StoryRepository extends CrudRepository<Story, Long> {

}
