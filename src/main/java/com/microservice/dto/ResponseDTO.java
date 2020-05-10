package com.microservice.dto;

public class ResponseDTO {

    public ResponseDTO() {

    }

    public ResponseDTO(Object body) {
        this.body = body;
    }

    private Object body;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

}
