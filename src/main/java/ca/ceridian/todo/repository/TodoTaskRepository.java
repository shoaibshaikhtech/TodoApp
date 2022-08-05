package ca.ceridian.todo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.ceridian.domain.TodoTask;

@Repository
public interface TodoTaskRepository extends JpaRepository<TodoTask, UUID>{

}
