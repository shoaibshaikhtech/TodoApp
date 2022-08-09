package ca.todo.events;

import java.util.UUID;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TodoEvent {
	private String eventName;
	private UUID todoId;
	private String todoTask;
	private boolean isCompleted = false; 
	
}
