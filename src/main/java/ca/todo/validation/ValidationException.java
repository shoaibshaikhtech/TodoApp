package ca.todo.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException extends RuntimeException{
	
	
	private List<ValidationError> errors;

    public ValidationException(String code, String message, String type) {        
        super(buildMessage(Arrays.asList(new ValidationError[] { new ValidationError(code, message).setType(type) })));
        errors = new ArrayList<>();
        errors.add(new ValidationError(code, message).setType(type));
    }
    
    private static String buildMessage(List<ValidationError> errors) {
        StringBuilder builder = new StringBuilder();
        builder.append("Your request did not pass.  Please see the errors:");
        for (ValidationError validationError : errors) {
            builder.append("\n");
            builder.append(" " + validationError.getType() + ": " + validationError.getMessage());
            if (validationError.getCode() != null) {
                builder.append(" (" + validationError.getCode() + ")");
            }
        }
        return builder.toString();
    }
    

}
