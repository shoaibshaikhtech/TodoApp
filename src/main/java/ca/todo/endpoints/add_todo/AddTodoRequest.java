package ca.todo.endpoints.add_todo;

import java.util.UUID;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AddTodoRequest {

	private UUID todoId = UUID.randomUUID();
	private String todo;
	private Boolean isCompleted = false;
}
