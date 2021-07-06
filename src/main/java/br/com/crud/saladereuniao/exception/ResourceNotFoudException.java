package br.com.crud.saladereuniao.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoudException extends Exception{

    private static final long serialVersionUID = 1L;

    public ResourceNotFoudException(String mensagem){
        super(mensagem);
    }
}
