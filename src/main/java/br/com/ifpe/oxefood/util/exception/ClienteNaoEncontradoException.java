package br.com.ifpe.oxefood.util.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends RuntimeException{

    public ClienteNaoEncontradoException(String entidade, ArrayList<Long> arrayList) {
        super(String.format("Não foi encontrado(a) um(a) %s com o id %s", entidade, arrayList.toString()));
        }
}