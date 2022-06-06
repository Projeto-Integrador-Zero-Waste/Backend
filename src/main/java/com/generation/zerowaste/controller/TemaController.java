package com.generation.zerowaste.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.zerowaste.model.Tema;
import com.generation.zerowaste.repository.TemaRepository;
@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
	private TemaRepository temaRepository;

	@GetMapping
    public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(temaRepository.findAll());
	}
    @GetMapping ("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable Long id ){
    	return temaRepository.findById(id)
    			.map(resposta -> ResponseEntity.ok(resposta))
    			.orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Tema>> getByTitulo(@PathVariable String titulo) {
    	return ResponseEntity.ok(temaRepository.findAllByTituloContainingIgnoreCase(titulo));
    }
    @PostMapping
    public ResponseEntity<Tema> postTema(@Valid @RequestBody Tema tema) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
    }
    @PutMapping
    public ResponseEntity<Tema> putTema(@Valid @RequestBody Tema tema) {
    	
    	if(tema.getId() == null) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	
    	return temaRepository.findById(tema.getId()) 
    			.map(resposta -> ResponseEntity.ok().body(temaRepository.save(tema)))
    			.orElse(ResponseEntity.notFound().build());
    			
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Tema> deleteTema(@PathVariable Long id) {
    	if(temaRepository.existsById(id)) {
    		temaRepository.deleteById(id);
    		return ResponseEntity.noContent().build(); 
    	}
    	return ResponseEntity.notFound().build();
    }
    
    
    
    
}
