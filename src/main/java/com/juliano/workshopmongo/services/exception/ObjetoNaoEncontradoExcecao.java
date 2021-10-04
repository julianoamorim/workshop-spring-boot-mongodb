package com.juliano.workshopmongo.services.exception;

public class ObjetoNaoEncontradoExcecao extends  RuntimeException{
    private static final long serialVersionUID = 1L; //permite q o objeto seja convertido em byte e trafegado em rede

    public ObjetoNaoEncontradoExcecao(String msg){
        super(msg);
    }
}
