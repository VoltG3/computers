package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L; //직렬화
	
	public ResourceNotFoundException(String message){
		super(message);
	}

}
//exception extends