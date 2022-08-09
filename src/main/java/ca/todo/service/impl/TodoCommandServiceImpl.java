package ca.todo.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.todo.domain.EventSource;
import ca.todo.endpoints.add_todo.AddTodoRequest;
import ca.todo.events.TodoEventName;
import ca.todo.repository.EventSourceRepository;
import ca.todo.service.TodoCommandService;

@Service
public class TodoCommandServiceImpl implements TodoCommandService{
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	@Autowired
	private KafkaTemplate<UUID, String> kafkaTemplate;
	
	@Autowired
	private EventSourceRepository repository;

	@Override
	public void createTodo(AddTodoRequest todo) {
		var event = new EventSource();
		event.setEventName(TodoEventName.CREATED.getKey());
		event.setTodoId(todo.getTodoId());
		event.setTodoTask(todo.getTodo());
		event.setCompleted(todo.getIsCompleted());
		repository.save(event);
		this.raiseEvent(event);
		
		
	}

	@Override
	public void deleteTodo(UUID todoId) {
		var event = new EventSource();
		event.setEventName(TodoEventName.DELETED.getKey());
		event.setTodoId(todoId);
		repository.save(event);
		this.raiseEvent(event);		
	}

	@Override
	public void complete(UUID todoId) {
		
		var event = new EventSource();
		event.setEventName(TodoEventName.COMPLETED.getKey());
		event.setTodoId(todoId);
		event.setCompleted(true);
		repository.save(event);
		this.raiseEvent(event);	
	}
	
	 private void raiseEvent(EventSource event){
	        try{
	            String value = OBJECT_MAPPER.writeValueAsString(event);
	            this.kafkaTemplate.send("todo-service-event", event.getEventId(), value);
//	            /this.kafkaTemplate.sendDefault(event.getEventId(), value);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }

}
