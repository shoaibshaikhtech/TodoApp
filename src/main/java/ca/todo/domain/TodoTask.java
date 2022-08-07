package ca.todo.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TodoTask {

	@Id
	@Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
	private UUID id = UUID.randomUUID();
	@Column(name="task")
	private String task;
	@Column(name = "completed")
	private boolean isCompleted = false;
}
