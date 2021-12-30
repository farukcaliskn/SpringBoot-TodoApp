package com.example.toDoList.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.toDoList.business.abstracts.ToDoService;
import com.example.toDoList.core.utilities.result.DataResult;
import com.example.toDoList.core.utilities.result.Result;
import com.example.toDoList.core.utilities.result.SuccessDataResult;
import com.example.toDoList.core.utilities.result.SuccessResult;
import com.example.toDoList.dataAccess.abstracts.ToDoDao;
import com.example.toDoList.entities.concrete.ToDo;

@Service
public class ToDoManeger implements ToDoService {
	private ToDoDao toDoDao;

	@Autowired
	public ToDoManeger(ToDoDao toDoDao) {
		super();
		this.toDoDao = toDoDao;
	}

	@Override
	public DataResult<List<ToDo>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ToDo>>(toDoDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(ToDo toDo) {
		// TODO Auto-generated method stub
		this.toDoDao.save(toDo);
		return new SuccessResult("Data Eklendi");

	}

	@Override
	public Result update(ToDo toDo) {
		// TODO Auto-generated method stub
		this.toDoDao.save(toDo);
		return new SuccessResult("Data Güncellendi");

	}

	@Override
	public Result delete(ToDo toDo) {
		// TODO Auto-generated method stub
		this.toDoDao.delete(toDo);
		return new SuccessResult("Data Silindi");

	}

	@Override
	public DataResult<ToDo> getBycompleted(Boolean completed) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<ToDo>(this.toDoDao.getBycompleted(completed), "Data listelendi");
	}

	@Override
	public DataResult<List<ToDo>> getAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<ToDo>>(this.toDoDao.findAll(pageable).getContent(), "Data listelendi");
	}

	@Override
	public DataResult<List<ToDo>> getByTodoContains(String todo) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ToDo>>(this.toDoDao.getByTodoContains(todo));
	}

}
