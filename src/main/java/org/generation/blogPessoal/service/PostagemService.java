package org.generation.blogPessoal.service;

import org.generation.blogPessoal.model.dto.PostagemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostagemService {

     PostagemDto save(PostagemDto postagemDto) ;

     void deleteById(long id);

     PostagemDto findById(long id) ;

     List<PostagemDto> findAll();

     Page<PostagemDto> findByCondition(PostagemDto postagemDto, Pageable pageable) ;

     PostagemDto update(PostagemDto postagemDto, long id) ;
}
