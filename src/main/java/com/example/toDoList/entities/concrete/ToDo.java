package com.example.toDoList.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "thingstodo")
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "title")
	@NotBlank
	@NotNull
	private String title;
	@Column(name = "todo")
	@NotEmpty
	@Size(min = 2, message = "Minimum boyut 2 karakter olmalıdır.")
	private String todo;
	@Column(name = "completed")
	private boolean completed;
}
