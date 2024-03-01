package com.example.storyteller.rest.controller;

import com.example.storyteller.dto.requestDto.CreatorRequestTo;
import com.example.storyteller.dto.responseDto.CreatorResponseTo;
import com.example.storyteller.repository.CreatorRepository;
import com.example.storyteller.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/creator")
public class CreatorController {

    private final CreatorService creatorService;

    @Autowired
    public CreatorController(CreatorService creatorService) {
        this.creatorService = creatorService;
    }

    @GetMapping("")
    public Iterable<CreatorResponseTo> getTasks() {
        return creatorService.findAllDtos();
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreatorResponseTo getTask(@PathVariable final Long id) {
        return creatorService.findDtoById(id);
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatorResponseTo addTask(@RequestBody CreatorRequestTo taskDto) {
        return creatorService.create(taskDto);
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreatorResponseTo updateTask(@RequestBody final CreatorRequestTo taskDto, @PathVariable final Long id) {
        return creatorService.update(taskDto, id);
    }

    //@PreAuthorize("@securityService.hasRole(#header)")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable final Long id) {
        creatorService.delete(id);
    }
}
