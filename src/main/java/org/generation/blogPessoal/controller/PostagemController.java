package org.generation.blogPessoal.controller;

import org.generation.blogPessoal.model.dto.PostagemDto;
import org.generation.blogPessoal.service.PostagemService;
import org.generation.blogPessoal.service.impl.PostagemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/postagem")
@RestController
public class PostagemController {
	private final PostagemService postagemService;

	@Autowired
	public PostagemController(PostagemServiceImpl postagemService) {
		this.postagemService = postagemService;
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Validated PostagemDto postagemDto) {
		postagemService.save(postagemDto);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<PostagemDto>> GetAll(){
		return ResponseEntity.ok(postagemService.findAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody @Validated PostagemDto postagemDto, @PathVariable("id") long id) {
		postagemService.update(postagemDto, id);
		return ResponseEntity.ok().build();
	}
}
