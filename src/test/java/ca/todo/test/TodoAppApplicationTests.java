package ca.todo.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TodoAppApplicationTests {

/*	@InjectMocks
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
	     }*/
}
