package com.juliano.workshopmongo.services;

import com.juliano.workshopmongo.domain.User;
import com.juliano.workshopmongo.repository.UserRepository;
import com.juliano.workshopmongo.services.exception.ObjetoNaoEncontradoExcecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Servico injetavel em outras classes
public class UserService {

    @Autowired //instancia automaticamente
    private UserRepository repo; //injecao de dependencia automatica

    public List<User> buscarTodos(){
        return repo.findAll(); //Metodo do MongoRepository
    }

    public User buscarId(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoExcecao("Objeto não encontrado"));
    }
}
