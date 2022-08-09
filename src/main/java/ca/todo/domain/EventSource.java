package ca.todo.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EventSource {
	
	@Id
	@Column(name = "eventId", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
	private UUID eventId = UUID.randomUUID();
	@Column(name = "eventName")
	private String eventName;
	@Column(name = "todoId", columnDefinition = "BINARY(16)")
	private UUID todoId;
	@Column(name="task")
	private String todoTask;
	@Column(name = "completed")
	private boolean isCompleted = false; 

}
