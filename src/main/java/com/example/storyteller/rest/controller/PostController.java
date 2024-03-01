package com.example.storyteller.rest.controller;

import com.example.storyteller.dto.requestDto.PostRequestTo;
import com.example.storyteller.dto.responseDto.PostResponseTo;
import com.example.storyteller.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public Iterable<PostResponseTo> getTasks() {
        return postService.findAllDtos();
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseTo getTask(@PathVariable final Long id) {
        return postService.findDtoById(id);
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponseTo addTask(@RequestBody PostRequestTo taskDto) {
        return postService.create(taskDto);
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseTo updateTask(@RequestBody final PostRequestTo taskDto, @PathVariable final Long id) {
        return postService.update(taskDto, id);
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable final Long id) {
        postService.delete(id);
    }
}
