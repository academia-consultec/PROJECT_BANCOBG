package com.consultec.org.banktest.controllers.custommessage;

import com.consultec.org.banktest.exceptions.HTTPErrorCodeException;
import com.consultec.org.banktest.exceptions.NotFoundErrorException;
import com.consultec.org.banktest.modelo.ErrorDTO;
import com.consultec.org.banktest.modelo.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final ResponseEntity handleAllExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        new ErrorDTO(500, "Error interno: " + ex.getMessage())
                );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ResponseEntity BadRequesthandleAllExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new ErrorDTO(400, "Error en el mensaje de URL del Request: " + ex.getMessage())
                );
    }



    @ExceptionHandler(NotFoundErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public final ResponseEntity NotFoundhandleAllExceptions(NotFoundErrorException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ErrorDTO(ex.getErrorCode().getIntCode(), ex.getMessage())
                );
    }


}
