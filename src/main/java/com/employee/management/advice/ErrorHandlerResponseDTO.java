package com.employee.management.advice;

public class ErrorHandlerResponseDTO {

    private String message;

    private String error;

    private Integer status;

    public ErrorHandlerResponseDTO() {
    }

    public ErrorHandlerResponseDTO(String message, String error, Integer status) {
        this.message = message;
        this.error = error;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
