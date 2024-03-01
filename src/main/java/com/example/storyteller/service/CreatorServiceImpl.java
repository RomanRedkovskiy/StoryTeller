package com.example.storyteller.service;

import com.example.storyteller.dto.requestDto.CreatorRequestTo;
import com.example.storyteller.dto.responseDto.CreatorResponseTo;
import com.example.storyteller.model.Creator;
import com.example.storyteller.repository.CreatorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CreatorServiceImpl implements CreatorService {

    private final CreatorRepository creatorRepository;

    @Autowired
    public CreatorServiceImpl(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }

    @Override
    public CreatorResponseTo create(CreatorRequestTo dto) {
        Creator creator = new Creator();
        requestDtoToCreator(creator, dto);
        creatorRepository.save(creator);
        return creatorToResponseDto(creator);
    }

    @Override
    public Iterable<CreatorResponseTo> findAllDtos() {
        return StreamSupport.stream(creatorRepository.findAll().spliterator(), false)
                .map(this::creatorToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CreatorResponseTo findDtoById(Long id) {
        return creatorToResponseDto(findCreatorById(id));
    }

    @Override
    public Creator findCreatorById(Long id) {
        return creatorRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Creator with id " + id + " can't be found"));
    }

    @Override
    public CreatorResponseTo update(CreatorRequestTo dto, Long id) {
        Creator creator = findCreatorById(id);
        requestDtoToCreator(creator, dto);
        creatorRepository.save(creator);
        return creatorToResponseDto(creator);
    }

    @Override
    public void delete(Long id) {
        Creator creator = findCreatorById(id);
        creatorRepository.delete(creator);
    }

    void requestDtoToCreator(Creator creator, CreatorRequestTo dto){
        creator.setLogin(dto.getLogin());
        creator.setPassword(dto.getPassword());
        creator.setFirstName(dto.getFirstName());
        creator.setLastName(dto.getLastName());
    }

    CreatorResponseTo creatorToResponseDto(Creator creator){
        CreatorResponseTo dto = new CreatorResponseTo();
        dto.setId(creator.getId());
        dto.setLogin(creator.getLogin());
        dto.setPassword(creator.getPassword());
        dto.setFirstName(creator.getFirstName());
        dto.setLastName(creator.getLastName());
        return dto;
    }
}
