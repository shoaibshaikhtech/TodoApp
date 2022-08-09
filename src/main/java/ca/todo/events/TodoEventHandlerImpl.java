package ca.todo.events;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.todo.domain.EventSource;
import ca.todo.domain.TodoTask;
import ca.todo.repository.TodoTaskRepository;

@Service
public class TodoEventHandlerImpl implements TodoEventHandler{
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private TodoTaskRepository repository;
	
	
	@KafkaListener(topics = "todo-service-event")
    public void consume(String todoTask) {
		System.out.println("Message Recieved " + todoTask);
        try{
        	EventSource todoEvent = OBJECT_MAPPER.readValue(todoTask, EventSource.class);
            this.upsertTodo(todoEvent);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	@Override
	public void upsertTodo(EventSource event) {
		if(event.getEventName().equalsIgnoreCase(TodoEventName.CREATED.getKey())) {
			createTodo(event.getTodoId(),event.getTodoTask(),event.isCompleted());
		}else if(event.getEventName().equalsIgnoreCase(TodoEventName.COMPLETED.getKey())) {
			completeTodo(event.getTodoId());
		}else if(event.getEventName().equalsIgnoreCase(TodoEventName.DELETED.getKey())) {
			deleteTodo(event.getTodoId());
		}
	}
	
	private void createTodo(UUID todoId, String todoTask, Boolean isCompleted) {
		var todo = new TodoTask();
		todo.setId(todoId);
		todo.setTask(todoTask);
		todo.setCompleted(isCompleted);
		repository.save(todo);
	}
	
	private void completeTodo(UUID todoId) {
		var todo = repository.findById(todoId);
		todo.get().setCompleted(true);
		repository.save(todo.get());
	}
	
	private void deleteTodo(UUID todoId){
		repository.deleteById(todoId);
	}

}
