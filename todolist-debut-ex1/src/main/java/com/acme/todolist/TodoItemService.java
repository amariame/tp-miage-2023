package com.acme.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {
  @Autowired
  private TodoItemRepository todoItemRepository;
  
  public List<TodoItem> getAllTache(){
    return  this.todoItemRepository.findAll();
  }

  public Optional<TodoItem> getTache(String id){
    return  this.todoItemRepository.findById(id);
  }
  
  public void updateTodoItem(TodoItem todoItem){
    this.todoItemRepository.save(todoItem);
  }
  
  public void ajouteTache(TodoItem todoItem){
    this.todoItemRepository.save(todoItem);
  }

}
