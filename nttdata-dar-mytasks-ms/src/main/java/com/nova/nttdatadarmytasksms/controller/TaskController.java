package com.nova.nttdatadarmytasksms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.nttdatadarmytasksms.repository.TaskRepository;

@RestController
public class TaskController {

	@Autowired
	TaskRepository repository;
	
	@GetMapping("/tasks/pending")
	public List<Task> getPendingTasks(){
		return repository.getPendingTasks();
	}
	
	@GetMapping("/tasks/completed")
	public List<Task> getCompletedTasks(){
		return repository.getCompletedTasks();
	}

}
