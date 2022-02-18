package org.generation.blogPessoal.service.impl;

import org.generation.blogPessoal.model.dto.PostagemDto;
import org.generation.blogPessoal.model.entity.PostagemEntity;
import org.generation.blogPessoal.model.mapper.PostagemMapper;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.generation.blogPessoal.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostagemServiceImpl implements PostagemService {
    private final PostagemRepository repository;
    private final PostagemMapper postagemMapper;

    @Autowired
    public PostagemServiceImpl(PostagemRepository repository, PostagemMapper postagemMapper) {
        this.repository = repository;
        this.postagemMapper = postagemMapper;
    }

    public PostagemDto save(PostagemDto postagemDto) {
        PostagemEntity entity = postagemMapper.toEntity(postagemDto);
        return postagemMapper.toDto(repository.save(entity));
    }

    public void deleteById(long id) {
        repository.delete(id);
    }

    public PostagemDto findById(long id) {
        return postagemMapper.toDto(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    public List<PostagemDto> findAll(){
        List<PostagemEntity> entities = repository.findAll();
        return postagemMapper.toDto(entities);
    };

    public Page<PostagemDto> findByCondition(PostagemDto postagemDto, Pageable pageable) {
        Page<PostagemEntity> entityPage = repository.findAll(pageable);
        List<PostagemEntity> entities = entityPage.getContent();
        return new PageImpl<>(postagemMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public PostagemDto update(PostagemDto postagemDto, long id) {
        PostagemDto data = findById(id);
        PostagemEntity entity = postagemMapper.toEntity(postagemDto);
        return save(postagemMapper.toDto(entity));
    }
}