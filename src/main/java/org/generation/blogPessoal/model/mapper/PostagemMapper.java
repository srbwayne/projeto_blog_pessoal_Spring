package org.generation.blogPessoal.model.mapper;

import org.generation.blogPessoal.model.dto.PostagemDto;
import org.generation.blogPessoal.model.entity.PostagemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostagemMapper extends EntityMapper<PostagemDto, PostagemEntity> {
}