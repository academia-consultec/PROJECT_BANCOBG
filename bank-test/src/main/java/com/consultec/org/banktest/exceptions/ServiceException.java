package com.consultec.org.banktest.exceptions;

public class ServiceException extends RuntimeException{

    public enum ListErrorCode {
        NOTFOUND(404);

        public final int errorCode;
        ListErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public int getIntCode() {
            return errorCode;
        }
    };

    private ListErrorCode listErrorCode;
    public ServiceException(ListErrorCode code, String message) {
        super(message);
        this.listErrorCode = code;
    }

    public ListErrorCode getErrorCode() {
        return listErrorCode;
    }
}
