package com.farmou.farmaciaCO.Controller;

import java.util.List;

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

import com.farmou.farmaciaCO.model.Post;
import com.farmou.farmaciaCO.repository.PostRepository;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins =  "*", allowedHeaders = "*")
public class PostController {
	
	@Autowired
	private PostRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Post>> GetAll(){
		return ResponseEntity.ok( repository.findAll());
	}
	
	@GetMapping	("/{id}")
	public ResponseEntity<Post> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());	
	}
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Post>> GetByCategoria(@PathVariable String categoria){
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria)); 
		
	}
	
	@PostMapping
	public ResponseEntity<Post> post (@RequestBody Post post){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(post));
	}
	
	@PutMapping
	public ResponseEntity<Post> put (@RequestBody Post post){
		return ResponseEntity.ok(repository.save(post));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
}
