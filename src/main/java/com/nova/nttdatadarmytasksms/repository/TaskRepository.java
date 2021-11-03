package com.nova.nttdatadarmytasksms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.nttdatadarmytasksms.controller.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	//	This implements automatically an abstract method that return a List of Task objects filtered by status
	List<Task> findByStatus(String status);	
}
