package com.acme.todolist.application.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.port.out.UpdateTodoItem;
import com.acme.todolist.domain.TodoItem;

@Component
public class AddTodoItemService implements AddTodoItem {

	private UpdateTodoItem updateTodoItem;
  


  //A compléter
	public AddTodoItemService(UpdateTodoItem updateTodoItem) {
    this.updateTodoItem = updateTodoItem;
  }
  
  //A compléter

  @Override
  public void addTodoItem(TodoItem item) {
    this.updateTodoItem.storeNewTodoItem(item);
  }
}
