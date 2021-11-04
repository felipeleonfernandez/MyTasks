package com.nova.nttdatadarmytasksms.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nova.nttdatadarmytasksms.controller.Task;

public class TaskRepositoryImpl implements TaskRepositoryCustom {

	@Autowired
	private TaskRepository repository;
	
	@Override
	public List<Task> getCompletedTasks() {
		List<Task> allTasks = repository.findAll();
		List<Task> completedTasks = new ArrayList<Task>();
		
		for(Task item : allTasks) {
			if(item.getStatus().equals("completed")) {
				completedTasks.add(item);
			}
		}
		
		return completedTasks;
	}

	@Override
	public List<Task> getPendingTasks() {
		List<Task> allTasks = repository.findAll();
		List<Task> completedTasks = new ArrayList<Task>();
		
		for(Task item : allTasks) {
			if(item.getStatus().equals("pending")) {
				completedTasks.add(item);
			}
		}
		
		return completedTasks;
	}
	
}
