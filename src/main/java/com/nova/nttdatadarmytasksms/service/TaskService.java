package com.nova.nttdatadarmytasksms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.nttdatadarmytasksms.controller.Task;
import com.nova.nttdatadarmytasksms.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository repository;
	
	public boolean checkExistingTask(int id) {
		Optional<Task> task = repository.findById(id);
		
		return task.isPresent();
	}
}
