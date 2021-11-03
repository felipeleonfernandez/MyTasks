package com.nova.nttdatadarmytasksms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.nova.nttdatadarmytasksms.repository.TaskRepository;
import com.nova.nttdatadarmytasksms.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	TaskRepository repository;
	
	@Autowired
	TaskService service;
	
	@GetMapping("/tasks/pending")
	public List<Task> getPendingTasks(){
		return repository.getPendingTasks();
	}
	
	@GetMapping("/tasks/completed")
	public List<Task> getCompletedTasks(){
		return repository.getCompletedTasks();
	}
	
	@PostMapping("/tasks")
	public ResponseEntity addNewTask(@RequestBody Task task) {
		ModifyTaskResponse res = new ModifyTaskResponse();
		
		if(task.getDescription().length() <= 256) {
			task.setStatus("pending");
			
			repository.save(task);
			
			return new ResponseEntity<>("OK: Task added", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("WARNING: Longer task description than allowed (>256)", HttpStatus.ACCEPTED);
		}
	}
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity deleteTask(@PathVariable(value="id")int id) {
		try {
			Task task = repository.findById(id).get();
			
			repository.delete(task);
			
			return new ResponseEntity<>("OK: Task deleted", HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>("ERROR: Task with ID=" + id + " not found", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/tasks/{id}")
	public ResponseEntity<ModifyTaskResponse> modifyTask(@PathVariable(value="id")int id, @RequestBody Task modifiedTask){
		ModifyTaskResponse res = new ModifyTaskResponse();
		
		try {
			Task task = repository.findById(id).get();
			
			task.setStatus(modifiedTask.getStatus());
			task.setDescription(modifiedTask.getDescription());
			
			repository.save(task);
			
			res.setId(id);
			res.setStatus(task.getStatus());
			res.setDescription(task.getDescription());
			res.setMsg("OK: Task modified");
			
			return new ResponseEntity<ModifyTaskResponse>(res, HttpStatus.OK);
		}catch(Exception e) {
			res.setMsg("ERROR: Task with ID=" + id + " not found");
			
			return new ResponseEntity<ModifyTaskResponse>(res, HttpStatus.NOT_FOUND);
		}		
	}
}
