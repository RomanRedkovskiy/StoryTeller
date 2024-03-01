package com.example.storyteller.rest.controller;

import com.example.storyteller.dto.requestDto.StoryRequestTo;
import com.example.storyteller.dto.responseDto.StoryResponseTo;
import com.example.storyteller.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/story")
public class StoryController {

    private final StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping("")
    public Iterable<StoryResponseTo> getTasks() {
        return storyService.findAllDtos();
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StoryResponseTo getTask(@PathVariable final Long id) {
        return storyService.findDtoById(id);
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public StoryResponseTo addTask(@RequestBody StoryRequestTo taskDto) {
        return storyService.create(taskDto);
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StoryResponseTo updateTask(@RequestBody final StoryRequestTo taskDto, @PathVariable final Long id) {
        return storyService.update(taskDto, id);
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable final Long id) {
        storyService.delete(id);
    }
}
