package org.ncu.departmentservice.handler;

import java.util.ArrayList;
import java.util.List;

import org.ncu.departmentservice.dto.ErrorResponse;
import org.ncu.departmentservice.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	private String NO_RECORDS_FOUND = "NO_RECORDS_FOUND";
	
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException e){

        List<String> errorDetails = new ArrayList<String>();
        errorDetails.add(e.getLocalizedMessage());
        ErrorResponse response = new ErrorResponse(NO_RECORDS_FOUND, errorDetails);

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
