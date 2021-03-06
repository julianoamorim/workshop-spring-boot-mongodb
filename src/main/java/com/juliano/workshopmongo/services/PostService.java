package com.juliano.workshopmongo.services;

import com.juliano.workshopmongo.domain.Post;
import com.juliano.workshopmongo.repository.PostRepository;
import com.juliano.workshopmongo.services.exception.ObjetoNaoEncontradoExcecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service //Servico injetavel em outras classes
public class PostService {

    @Autowired //instancia automaticamente
    private PostRepository repo; //injecao de dependencia automatica / acesso ao banco de dados

    public Post buscarId(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoExcecao("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.buscarTitulo(text);
    }

    public List<Post> buscaCompleta(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24*60*60*1000); //data maxima +24hrs
        return repo.buscaCompleta(text, minDate, maxDate);
    }

}
