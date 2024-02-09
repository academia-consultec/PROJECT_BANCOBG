package com.consultec.org.banktest.exceptions;

public class NotFoundErrorException extends HTTPErrorCodeException{
    public NotFoundErrorException(ListErrorCode code, String message) {
        super(code, message);
    }
}
