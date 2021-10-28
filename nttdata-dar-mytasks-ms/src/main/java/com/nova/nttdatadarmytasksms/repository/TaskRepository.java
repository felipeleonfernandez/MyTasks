package com.nova.nttdatadarmytasksms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.nttdatadarmytasksms.controller.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>, TaskRepositoryCustom {

}
