package ca.ceridian.validation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ValidationError {
    private String code;
    private String message;
    private String type = ValidationType.UNSPECIFIED;

    public ValidationError(String code, String message) {
        this.code = code;
        this.message = message;
    }    

    public ValidationError() {        
    }
}

