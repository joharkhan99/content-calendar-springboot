package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import model.Content;
import repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {
	
	private final ContentCollectionRepository repository;
	
	public ContentController(ContentCollectionRepository repository) {
		this.repository = repository;
	}
	
	//	make a request and find all the pieces of content in the system
	//	the kind of main or home request like /api/content
	@GetMapping("")
	public List<Content> findAll(){
		System.out.println(repository.findAll());
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Content findById(@PathVariable Integer id){
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found!"));
	}
	

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void create(@RequestBody Content content) {
		repository.save(content);
	}
	
}
