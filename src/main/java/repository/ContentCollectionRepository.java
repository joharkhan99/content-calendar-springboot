package repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import model.Content;
import model.Status;
import model.Type;

@Repository
public class ContentCollectionRepository {
	
	private final List<Content> contentList = new ArrayList<>();
	
	public ContentCollectionRepository() {
		
	}
	
	public List<Content> findAll(){
		return contentList;
	}
	
	public Optional<Content> findById(Integer id){
		return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
	}
	
	@PostConstruct
	private void init() {
		Content c = new Content(1, "My first Blog Post", "My first...", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, "");
		contentList.add(c);
	}

	public void save(Content content) {
		contentList.removeIf(c -> c.id().equals(content.id())); //for update/PUT method
		contentList.add(content);
	}

	public boolean existsById(Integer id) {
		return contentList.stream().filter(c -> c.id().equals(id)).count()==1;
	}

	public void delete(Integer id) {
		contentList.removeIf(c -> c.id().equals(id));
	}
	
}
