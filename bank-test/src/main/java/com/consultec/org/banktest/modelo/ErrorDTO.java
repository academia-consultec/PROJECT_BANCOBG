package com.consultec.org.banktest.modelo;

import java.io.Serializable;

public class ErrorDTO extends ResponseDTO{
    private int errorCode;
    private String mensaje;

    public ErrorDTO(int errorCode, String mensaje) {
        this.errorCode = errorCode;
        this.mensaje = mensaje;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
