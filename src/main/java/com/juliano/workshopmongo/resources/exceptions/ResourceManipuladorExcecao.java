package com.juliano.workshopmongo.resources.exceptions;

import com.juliano.workshopmongo.services.exception.ObjetoNaoEncontradoExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceManipuladorExcecao {

    @ExceptionHandler(ObjetoNaoEncontradoExcecao.class)
    public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoExcecao e, HttpServletRequest request){


        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao err = new ErroPadrao(System.currentTimeMillis(), status.value(),
                "Não encontrado", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
