package com.acme.todolist;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {

  @Autowired
  private TodoItemService todoItemService;

	private static final String LATE = "[LATE!]";
  
  
	public TodoListController() {
		super();		
	}

	@PostMapping("/todos")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createTodoItem(@RequestBody TodoItem todoItem) {
		this.todoItemService.ajouteTache(todoItem);
	}

	@GetMapping("/todos")
	public List<TodoItem> todoItems() {
		return this.todoItemService.getAllTache().stream()
				.map(item -> new TodoItem(item.getId(), item.getTime(), finalContent(item)))
				.collect(Collectors.toList());

	}
  
  @GetMapping("/todos/{id}")
  public Optional<TodoItem> todoItem(@PathVariable("id") String id){
    return  this.todoItemService.getTache(id);
  }
  
  
  @PostMapping("todos/{id}")
  public void saveTodoItem(@PathVariable("id") String id, @RequestBody TodoItem todoItem){
    
  }

	/**
	 * RG 1 : si l'item a plus de 24h, ajouter dans le contenu une note "[LATE!]"
	 * 
	 * @return liste des items
	 */
	private String finalContent(TodoItem item) {
		return (Instant.now().isAfter(item.getTime().plus(1, ChronoUnit.DAYS))) ? 
				LATE + item.getContent()
				: item.getContent();
	}

}
