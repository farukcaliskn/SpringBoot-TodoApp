package com.example.toDoList.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.toDoList.business.abstracts.ToDoService;
import com.example.toDoList.core.utilities.result.DataResult;
import com.example.toDoList.core.utilities.result.ErrorDataResult;
import com.example.toDoList.core.utilities.result.Result;
import com.example.toDoList.entities.concrete.ToDo;

@RestController
@RequestMapping("/api")
public class ToDoController {
	private ToDoService toDoService;

	public ToDoController(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}

	@GetMapping("/getAll")
	public DataResult<List<ToDo>> getAll() {
		return toDoService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ToDo toDo) {
		return ResponseEntity.ok(this.toDoService.add(toDo));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");
		return errors;
	}

	@PostMapping("/update")
	public Result update(@RequestBody ToDo toDo) {
		return this.toDoService.update(toDo);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody ToDo toDo) {
		return this.toDoService.delete(toDo);
	}

	@GetMapping("/getBycompleted")
	public DataResult<ToDo> getBycompleted(@RequestParam Boolean completed) {
		return this.toDoService.getBycompleted(completed);
	}

	@GetMapping("/getAllByPage")
	DataResult<List<ToDo>> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.toDoService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getByTodoContains")
	DataResult<List<ToDo>> getByTodoContains(@RequestParam String todo) {
		return this.toDoService.getByTodoContains(todo);
	}
}
