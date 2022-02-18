package org.generation.blogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.entity.PostagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemEntity, Long> {
	List<PostagemEntity> findAllByTituloContainingIgnoreCase (String titulo);

	Optional<PostagemEntity> findById(Long id);
}
