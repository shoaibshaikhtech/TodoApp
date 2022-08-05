package ca.ceridian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ca.ceridian.domain.TodoTask;
import ca.ceridian.todo.endpoints.add_todo.AddTodoEndpoint;
import ca.ceridian.todo.endpoints.complete_todo.CompleteTodoEndpoint;
import ca.ceridian.todo.repository.TodoTaskRepository;

@ExtendWith(MockitoExtension.class)
class TodoAppApplicationTests {

	@InjectMocks
	AddTodoEndpoint addTodoEndpoint;
	
	@InjectMocks
	CompleteTodoEndpoint completeTodoEndpoint;

	@Mock
	TodoTaskRepository mockRepository;
	     
	    @Test
	    public void testAddTodoTask() 
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	         
	        when(mockRepository.save(any(TodoTask.class))).thenReturn(new TodoTask());
	         
	        TodoTask task = new TodoTask();
	        task.setTask("Mock Task");
	        String s = addTodoEndpoint.addTodoTask(task);
	        
	        assertEquals("redirect:/", s);
	     }
	    
	    @Test
	    public void testCompleteTodoTask() 
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	         
	        when(mockRepository.findById(any(UUID.class))).thenReturn(Optional.of(new TodoTask()));
	         
	
	        String s = completeTodoEndpoint.completeTodo(UUID.randomUUID(), Mockito.any());
	        
	        assertEquals("redirect:/list", s);
	     }
}
