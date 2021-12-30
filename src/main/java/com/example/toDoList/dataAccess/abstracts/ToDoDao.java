package com.example.toDoList.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.toDoList.entities.concrete.ToDo;

public interface ToDoDao extends JpaRepository<ToDo, Integer> {

	ToDo getBycompleted(Boolean completed);

	List<ToDo> getByTodoContains(String todo);
}
