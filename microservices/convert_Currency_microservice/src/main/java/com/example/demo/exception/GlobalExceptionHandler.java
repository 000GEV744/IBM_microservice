package com.example.demo.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.demo.feignClient.model.ApiException;

import feign.FeignException;
//import feign.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> handleFeignStatusException(FeignException e, HttpServletResponse response) {
        
//		response.setStatus(e.status());
        
		int status = e.status();
		HttpStatus error = HttpStatus.resolve(status);
		
		ApiException apiException = new ApiException
				(
				    ZonedDateTime.now(ZoneId.of("Asia/Kolkata")),
			       status, 
			       error,
			       e.getMessage()
				   );
		
		return new ResponseEntity<>(apiException, error);
    }
	
	
	//incase of updation, constraint voilation (i.e. @PathVariable and @Requestbody)
		@ExceptionHandler({
				MissingPathVariableException.class,
				TypeMismatchException.class,
				MethodArgumentNotValidException.class,
				ConstraintViolationException.class,
				HttpRequestMethodNotSupportedException.class
				})
		public ResponseEntity<Object> handleBadRequestException(Exception ex){
			HttpStatus error = null;
			if(ex instanceof HttpRequestMethodNotSupportedException) {
				 error = HttpStatus.METHOD_NOT_ALLOWED;
			}
			else {
			error = HttpStatus.BAD_REQUEST;
			}
			int status = error.value();
			ApiException apiException = new ApiException
					(
					    ZonedDateTime.now(ZoneId.of("Asia/Kolkata")),
				       status, 
				       error,
				       ex.getMessage()
					   );
			
			return new ResponseEntity<>(apiException, error);
		}

}
