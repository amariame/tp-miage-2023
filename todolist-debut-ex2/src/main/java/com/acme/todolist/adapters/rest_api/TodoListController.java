package com.acme.todolist.adapters.rest_api;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import com.acme.todolist.application.port.in.AddTodoItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQuery;
	// A compléter
	private AddTodoItem addTodoItemQuery;
	
	@Inject
	//A compléter
	public TodoListController(GetTodoItems getTodoItemsQuery ) {
		this.getTodoItemsQuery = getTodoItemsQuery;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	// Endpoint de type POST vers "/todos"
	// A compléter

  @PostMapping("/todos")
  @ResponseStatus(code = HttpStatus.CREATED)
  public ResponseEntity<Void> ajouterItem(@RequestBody TodoItem item) throws IOException {
    
    this.addTodoItemQuery.addTodoItem(item);
    return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
}
