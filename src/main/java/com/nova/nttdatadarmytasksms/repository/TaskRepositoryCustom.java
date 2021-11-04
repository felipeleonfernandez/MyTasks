package com.nova.nttdatadarmytasksms.repository;

import java.util.List;

import com.nova.nttdatadarmytasksms.controller.Task;

public interface TaskRepositoryCustom {
	List<Task> getCompletedTasks();
	List<Task> getPendingTasks();
}
