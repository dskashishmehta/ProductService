package com.scaler.ProductService.advices;

import com.scaler.ProductService.dtos.ArithmeticExceptionDto;
import com.scaler.ProductService.dtos.ArrayIndexOutOfBoundExceptiondto;
import com.scaler.ProductService.dtos.ExceptionDto;
import com.scaler.ProductService.exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(){
        ArithmeticExceptionDto dto = new ArithmeticExceptionDto();
        dto.setMessage("This is Arithmetic Exception");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ArrayIndexOutOfBoundExceptiondto> handleArrayOutOfBoundException(){
        return null;
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ExceptionDto> InvalidProductIdExceptionHandle(InvalidProductIdException exception){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setProductId(exception.getProductId());
        exceptionDto.setMessage("Please enter the valid product id, thanks!!");
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
