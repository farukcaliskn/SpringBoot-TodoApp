package com.example.toDoList.business.abstracts;

import java.util.List;

import com.example.toDoList.core.utilities.result.DataResult;
import com.example.toDoList.core.utilities.result.Result;
import com.example.toDoList.entities.concrete.ToDo;

public interface ToDoService {

	DataResult<List<ToDo>> getAll();

	DataResult<List<ToDo>> getAll(int pageNo, int pageSize);

	Result add(ToDo toDo);

	Result update(ToDo toDo);

	Result delete(ToDo toDo);

	DataResult<ToDo> getBycompleted(Boolean completed);

	DataResult<List<ToDo>> getByTodoContains(String todo);
}
